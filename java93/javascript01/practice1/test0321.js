

"use strict"

var a = new Array(20)
for (var i; i < a.length; i++)
  a[i] = 2 * i + 1
  console.log(a[i])

for ( var i = 0; i<a.length; i++)
  console.log(a[i])
  console.log(a)

var a = [10, 74, 25, 47, 66, 29, 5]

var maxv = a[0]
for(var i = 1;i < a.length;i++){
  if(a[i] > maxv)
  maxv = a[i];
}

console.log('최대값', maxv)





<!-- -->
