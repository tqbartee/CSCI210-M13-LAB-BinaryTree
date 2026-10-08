import com.zybooks.dsaj.treebook.LinkedBinaryTree;
import com.zybooks.dsaj.treebook.Position;

import javax.swing.*;
import java.awt.*;

public class SwingBinaryTreeDisplay {

    static class BinaryTreePanel<E> extends JPanel {
        private final LinkedBinaryTree<E> tree;
        private final int nodeRadius = 24;
        private final int vGap = 70;

        public BinaryTreePanel(LinkedBinaryTree<E> tree) {
            this.tree = tree;
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (tree.root() != null) {
                drawTree(g, tree.root(), getWidth() / 2, 40, getWidth() / 4, 0);
            }
        }

        private void drawTree(Graphics g, Position<E> p, int x, int y, int hGap, int level) {
            if (level > 3 || p == null) {
                return; // limit drawing to levels 0–3
            }

            g.setColor(Color.BLACK);
            g.drawOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
            String text = p.getElement() != null ? p.getElement().toString() : "";
            
            // Handle multi-line strings for display (first line only for node label)
            String firstLine = text.split("\n")[0];
            g.drawString(firstLine, x - g.getFontMetrics().stringWidth(firstLine) / 2, y + 5);

            if (tree.left(p) != null) {
                int childX = x - hGap;
                int childY = y + vGap;
                g.drawLine(x, y + nodeRadius, childX, childY - nodeRadius);
                drawTree(g, tree.left(p), childX, childY, hGap / 2, level + 1);
            }

            if (tree.right(p) != null) {
                int childX = x + hGap;
                int childY = y + vGap;
                g.drawLine(x, y + nodeRadius, childX, childY - nodeRadius);
                drawTree(g, tree.right(p), childX, childY, hGap / 2, level + 1);
            }
        }
    }

    public static <E> void showInWindow(LinkedBinaryTree<E> T) {
        JFrame frame = new JFrame("LinkedBinaryTree Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new BinaryTreePanel<>(T));
        frame.setVisible(true);
    }
}
