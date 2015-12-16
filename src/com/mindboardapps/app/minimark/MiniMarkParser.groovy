package com.mindboardapps.app.minimark

import org.parboiled.BaseParser
import org.parboiled.Rule
import org.parboiled.annotations.BuildParseTree

@BuildParseTree 
class MiniMarkParser extends BaseParser<Object> {

    Rule Doc() {
        ZeroOrMore(Block())
    }

    Rule Block(){
        FirstOf( NewLine(), HeadLine(), ImageLine(), ParaLine() )
    }

    Rule HeadLine(){
        Sequence( HeadMark(), OneOrMoreSpaces(), Inline(), NewLine() )
    }

    Rule HeadMark(){
        OneOrMore('#')
    }

    Rule ParaLine(){
        Sequence( Inline(), NewLine() )
    }

    Rule Inline(){
        ZeroOrMore(NoneOf('\n'))
    }

    Rule NewLine(){
        String('\n')
    }

    Rule OneOrMoreSpaces(){
        OneOrMore(' ')
    }

    Rule ImageLine(){
        Sequence(
            ZeroOrMoreSpaces(),
            String('!['), ImageAlt(), String(']('), ImagePath(), String(')'),
            ZeroOrMoreSpaces(), NewLine() )
    }

    Rule ImageAlt(){
        ZeroOrMore(NoneOf('\n]'))
    }

    Rule ImagePath(){
        ZeroOrMore(NoneOf('\n)'))
    }

    Rule ZeroOrMoreSpaces(){
        ZeroOrMore(' ')
    }
}
