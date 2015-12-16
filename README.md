
# mini-mark parser with parboiled

```
Doc      ← Block*
Block    ← NewLine / HeadLine / ParaLine
HeadLine ← #+ Spaces ParaLine
ParaLine ← Inline NewLine
Inline   ← \n以外のすべての文字*
NewLine  ← \n
Spaces   ← ' '+
```
