class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p==null && q==null) {
        //     return true;
        // }
        // if(p==null || q==null) return false;
        // if(p.val != q.val) return false;

        // return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    

         Stack<TreeNode> stack_p = new Stack <> ();       
	     Stack<TreeNode> stack_q = new Stack <> ();
	     if (p != null) stack_p.push( p ) ;
	     if (q != null) stack_q.push( q ) ;
	     while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
	    	 TreeNode pn = stack_p.pop() ;
	    	 TreeNode qn = stack_q.pop() ;	    	
	    	 if (pn.val != qn.val) return false ;
	    	 if (pn.right != null) stack_p.push(pn.right) ;
	    	 if (qn.right != null) stack_q.push(qn.right) ;
	    	 if (stack_p.size() != stack_q.size()) return false ;
	    	 if (pn.left != null) stack_p.push(pn.left) ;	    	 	    	 
	    	 if (qn.left != null) stack_q.push(qn.left) ;
	    	 if (stack_p.size() != stack_q.size()) return false ;
	     }		     
	     return stack_p.size() == stack_q.size() ;
    }
}