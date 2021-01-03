package Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree;

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3590/

import java.util.ArrayList;

class Solution {

  ArrayList<Character> dirList = new ArrayList<>();
  Boolean found = false;

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
      final TreeNode target) {

    TreeNode answer = cloned;
    dirFinder(original, target);

    for(Character dir:dirList){
      switch (dir) {
        case 'L': answer = answer.left; break;
        case 'R': answer = answer.right; break;
      }
    }

    return answer;
  }

  private void dirFinder(final TreeNode curNode, final TreeNode target) {
    if (curNode == target) {
      found = true;
      return;
    }

    if (curNode.left != null) {
      dirList.add('L');
      dirFinder(curNode.left, target);
      if(found) return;
      dirList.remove(dirList.size() - 1);
    }

    if (curNode.right != null) {
      dirList.add('R');
      dirFinder(curNode.right, target);
      if(found) return;
      dirList.remove(dirList.size() - 1);
    }
  }
}