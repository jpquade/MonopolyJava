package Test;

import main.Enums.Chance;
import main.Enums.CommunityChest;
import main.GUI.DrawCardGUI;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DrawCardGUITest {

    private JLayeredPane pane;
    private JLabel label;
    private JButton button;
    private DrawCardGUI drawCardGUI;

    @Before
    public void setUp() throws IOException {
        pane = new JLayeredPane();
        label = new JLabel();
        button = new JButton();
        drawCardGUI = new DrawCardGUI(pane);
    }

    @Test
    public void testDrawAChanceCard() {
        Chance drawnCard = drawCardGUI.drawAChanceCard();
        assertNotNull(drawnCard, "The drawn card should not be null");
        assertTrue(button.isVisible(), "The button should be visible after drawing a card");
        assertTrue(label.isVisible(), "The label should be visible after drawing a card");
    }

//    @Test
//    public void testDrawACommunityChestCard() {
//        // Assuming you have a similar method for drawing community chest cards
//        CommunityChest drawnCard = drawCardGUI.drawACommunityChestCard(label, button);
//        assertNotNull(drawnCard, "The drawn card should not be null");
//        assertTrue(button.isVisible(), "The button should be visible after drawing a card");
//        assertTrue(label.isVisible(), "The label should be visible after drawing a card");
//    }
}