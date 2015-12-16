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
        FirstOf( NewLine(), HeadLine(), ParaLine() )
    }

    Rule HeadLine(){
        Sequence( OneOrMore('#'), Spaces(), ParaLine() )
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

    Rule Spaces(){
        OneOrMore(' ')
    }
}
