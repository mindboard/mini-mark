
# mini-mark parser with parboiled

```
Doc      ← Block*
Block    ← NewLine / HeadLine / ParaLine / ImageLine

NewLine  ← '\n'

HeadLine ← '#'+ Spaces Inline NewLine
ParaLine ← Inline NewLine
Inline   ← \n以外のすべての文字*
Spaces   ← ' '+

ImageLine← '![' ImageAlt '](' ImagePath ')' ' '* NewLine
ImageAlt ← Inline
ImagePath← Inline
```

more details http://qiita.com/mindboard/items/660f621123cfaa001cf1
