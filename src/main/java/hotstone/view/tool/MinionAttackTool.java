package hotstone.view.tool;

import hotstone.framework.Card;
import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.Status;
import hotstone.view.GfxConstants;
import hotstone.view.figure.HotStoneActorFigure;
import hotstone.view.figure.HotStoneFigureType;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.ZOrder;
import minidraw.standard.NullTool;

import java.awt.event.MouseEvent;

public class MinionAttackTool extends NullTool {
    private DrawingEditor editor;
    private Game game;
    private HotStoneActorFigure draggedActor;
    private int lastX;
    private int lastY;
    private int orgX;
    private int orgY;
    private Player whoAmIPlaying;

    public MinionAttackTool(DrawingEditor editor, Game game, Player whoAmIPlaying) {
        this.editor = editor;
        this.game = game;
        this.whoAmIPlaying = whoAmIPlaying;
    }

    @Override
    public void mouseDown(MouseEvent e, int x, int y) {
        Drawing model = editor.drawing();
        Figure figureAtPosition = model.findFigure(e.getX(), e.getY());
        draggedActor = (HotStoneActorFigure) figureAtPosition;
        model.zOrder(draggedActor, ZOrder.TO_TOP);
        lastX = x; lastY = y;
        orgX = x; orgY = y;
    }

    @Override
    public void mouseDrag(MouseEvent e, int x, int y) {
        // compute relative movement
        draggedActor.moveBy(x - lastX, y - lastY);
        // update last position
        lastX = x; lastY = y;
    }

    @Override
    public void mouseUp(MouseEvent e, int x, int y) {
      // Invoke related facade method, if figure is a card
      boolean isDraggingAnActor = draggedActor != null;
      boolean isHittingField = y < GfxConstants.Y_LIMIT_OF_FIELD;
      boolean moveCardBack = true;
  
      if (isDraggingAnActor && isHittingField) {
        Card attackingCard = draggedActor.getAssociatedCard();
        // TODO: Do the actual call instead of this fake code
        System.out.println("TODO: Do the actual call to the domain code...");
        Drawing model = editor.drawing();
        Figure figureAtPosition = model.findFigure(e.getX(), e.getY());
        HotStoneActorFigure otherDraggedActor = (HotStoneActorFigure) figureAtPosition;
        
        if (otherDraggedActor.getType() == HotStoneFigureType.MINION_FIGURE) {
            
        }
        Card defendingCard = otherDraggedActor.getAssociatedCard();
        

        Status status = game.attackCard(whoAmIPlaying, attackingCard, defendingCard);
        if (status == Status.OK) {
          moveCardBack = false;
        }
        editor.showStatus("Draw card from hand. Result =" + status);
      }
      if (moveCardBack) {
        // move back to original position
        draggedActor.moveBy(orgX - x, orgY - y);
      }
      draggedActor = null;
    }
    
}
