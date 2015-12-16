
# mini-mark parser with parboiled

```
Doc              ← Block*
Block            ← NewLine / HeadLine / ParaLine / ImageLine

HeadLine         ← HeadMark OneOrMoreSpaces Inline NewLine
HeadMark         ← '#'+
ParaLine         ← Inline NewLine
Inline           ← '\n'以外のすべての文字*
OneOrMoreSpaces  ← ' '+

ImageLine        ← ZeroOrMoreSpaces '![' ImageAlt '](' ImagePath ')' ZeroOrMoreSpaces NewLine
ImageAlt         ← '\n'と']'以外のすべての文字*
ImagePath        ← '\n'と')'以外のすべての文字*
ZeroOrMoreSpaces ← ' '+

NewLine          ← '\n'
```

more details http://qiita.com/mindboard/items/660f621123cfaa001cf1
