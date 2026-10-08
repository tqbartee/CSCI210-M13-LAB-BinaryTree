import com.zybooks.dsaj.treebook.LinkedBinaryTree;
import com.zybooks.dsaj.treebook.Position;
import edu.desu.utilities.UtilityMethodsBinaryTreeBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BuildBinaryTree831BookTest {

    private LinkedBinaryTree<String> tree;

    @BeforeEach
    public void setUp() {
        tree = BuildBinaryTree831Book.buildTree();
    }

    @Test
    @DisplayName("Test that buildTree returns a non-null binary tree")
    public void testTreeNotNull() {
        assertNotNull(tree, "Tree should not be null");
        assertFalse(tree.isEmpty(), "Tree should not be empty");
    }

    @Test
    @DisplayName("Test tree size is 5")
    public void testTreeSize() {
        assertEquals(5, tree.size(), "Tree should contain 5 nodes");
    }

    @Test
    @DisplayName("Test root element is Providence")
    public void testRoot() {
        Position<String> root = tree.root();
        assertNotNull(root, "Root should not be null");
        assertEquals("Providence", root.getElement(), "Root element should be Providence");
        assertNull(tree.parent(root), "Root parent should be null");
    }

    @Test
    @DisplayName("Test root's left and right children")
    public void testRootChildren() {
        Position<String> root = tree.root();
        Position<String> left = tree.left(root);
        Position<String> right = tree.right(root);

        assertNotNull(left, "Root left child (Chicago) should not be null");
        assertEquals("Chicago", left.getElement(), "Root left child should be Chicago");
        assertEquals(root, tree.parent(left), "Chicago's parent should be Providence");

        assertNotNull(right, "Root right child (Seattle) should not be null");
        assertEquals("Seattle", right.getElement(), "Root right child should be Seattle");
        assertEquals(root, tree.parent(right), "Seattle's parent should be Providence");
    }

    @Test
    @DisplayName("Test Chicago's left and right children")
    public void testChicagoChildren() {
        Position<String> root = tree.root();
        Position<String> chicago = tree.left(root);

        Position<String> baltimore = tree.left(chicago);
        Position<String> newYork = tree.right(chicago);

        assertNotNull(baltimore, "Chicago left child (Baltimore) should not be null");
        assertEquals("Baltimore", baltimore.getElement(), "Chicago left child should be Baltimore");
        assertEquals(chicago, tree.parent(baltimore), "Baltimore's parent should be Chicago");

        assertNotNull(newYork, "Chicago right child (New York) should not be null");
        assertEquals("New York", newYork.getElement(), "Chicago right child should be New York");
        assertEquals(chicago, tree.parent(newYork), "New York's parent should be Chicago");
    }

    @Test
    @DisplayName("Test leaf nodes have no children")
    public void testLeafNodes() {
        Position<String> root = tree.root();
        Position<String> chicago = tree.left(root);
        Position<String> seattle = tree.right(root);
        Position<String> baltimore = tree.left(chicago);
        Position<String> newYork = tree.right(chicago);

        assertNull(tree.left(baltimore), "Baltimore left child should be null");
        assertNull(tree.right(baltimore), "Baltimore right child should be null");
        assertEquals(0, tree.numChildren(baltimore), "Baltimore should have 0 children");

        assertNull(tree.left(newYork), "New York left child should be null");
        assertNull(tree.right(newYork), "New York right child should be null");
        assertEquals(0, tree.numChildren(newYork), "New York should have 0 children");

        assertNull(tree.left(seattle), "Seattle left child should be null");
        assertNull(tree.right(seattle), "Seattle right child should be null");
        assertEquals(0, tree.numChildren(seattle), "Seattle should have 0 children");
    }

    @Test
    @DisplayName("Test inorder traversal order of positions")
    public void testInorderTraversal() {
        List<String> elementsInOrder = new ArrayList<>();
        for (Position<String> p : tree.inorder()) {
            elementsInOrder.add(p.getElement());
        }

        List<String> expectedOrder = List.of("Baltimore", "Chicago", "New York", "Providence", "Seattle");
        assertEquals(expectedOrder, elementsInOrder, "Inorder traversal should match expected order");
    }

    @Test
    @DisplayName("Test UtilityMethodsBinaryTreeBook.printBinaryTreeInorder output")
    public void testPrintBinaryTreeInorder() {
        String result = UtilityMethodsBinaryTreeBook.printBinaryTreeInorder(tree);
        String expected = "Baltimore\nChicago\nNew York\nProvidence\nSeattle";
        assertEquals(expected, result, "Formatted inorder traversal string should match expected");
    }
}
