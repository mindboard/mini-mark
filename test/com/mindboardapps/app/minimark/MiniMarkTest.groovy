package com.mindboardapps.app.minimark

import org.parboiled.Parboiled
import org.parboiled.errors.ErrorUtils
import org.parboiled.support.ParseTreeUtils
import org.parboiled.parserunners.ReportingParseRunner
import org.parboiled.support.ParsingResult

import spock.lang.Specification

class MiniMarkTest extends Specification {

    def "パース結果の確認"(){

        when:
        def parser = Parboiled.createParser(MiniMarkParser.class)

        def input = '''\
            |
            |# h1 header
            |
            |This is a paragraph.
            |
            |## h2 header
            |
            |This is another paragraph.
            |
            |'''.stripMargin('|')

        ParsingResult<Object> result = new ReportingParseRunner(parser.Doc()).run(input);

        if (!result.parseErrors.isEmpty()){
            println (ErrorUtils.printParseError(result.parseErrors.get(0)));
        }
        else {
            println(ParseTreeUtils.printNodeTree(result) + '\n');
        }


        def toString = { node->
            return input.substring(node.startIndex, node.endIndex)
        }

        def header1 = toString(result.parseTreeRoot.children[1])
        def para1   = toString(result.parseTreeRoot.children[3])
        def header2 = toString(result.parseTreeRoot.children[5])
        def para2   = toString(result.parseTreeRoot.children[7])

        then:
        header1 == '# h1 header\n'
        para1   == 'This is a paragraph.\n'
        header2 == '## h2 header\n'
        para2   == 'This is another paragraph.\n'
    }
}
