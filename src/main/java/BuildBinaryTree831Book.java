import com.zybooks.dsaj.treebook.LinkedBinaryTree;
import com.zybooks.dsaj.treebook.Position;
import edu.desu.utilities.UtilityMethodsBinaryTreeBook;

public class BuildBinaryTree831Book {

    public static LinkedBinaryTree<String> buildTree() {
        LinkedBinaryTree<String> T = new LinkedBinaryTree<>();
        // //TODO: implement book code fragment 8.3.1
        // Recommended: Declare objects pvd, chi, sea, bal, and nyc
        // as type Position<String>
        // Position is an object type that is a node of the tree
        // (as described in the book)
        // Then code fragment 8.3.1 commands should work
        return T;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<String> T = buildTree();
        String treeString = UtilityMethodsBinaryTreeBook.printBinaryTreeInorder(T);
        System.out.println("The tree traversal inorder is: ");
        System.out.println(treeString);
        SwingBinaryTreeDisplay.showInWindow(T);
    }
}
