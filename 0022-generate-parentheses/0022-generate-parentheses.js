/**
 * @param {number} n
 * @return {string[]}
 */
 var ans;
 function generate(op, cl, n, st){
    if(op == cl && op==n) {
        ans.push(st);
        return;
    }
    if(op<n) generate(op+1, cl, n, st+"(");
    if(cl<op) generate(op, cl+1, n, st+")")
    
 }
var generateParenthesis = function(n) {
    ans=[];
    generate(0, 0, n, "");
    return ans;
};