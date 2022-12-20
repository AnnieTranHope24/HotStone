package hotstone.view.tool;

import hotstone.framework.Hero;
import hotstone.standard.game.GameMutator;
import hotstone.view.figure.HeroFigure;
import hotstone.view.figure.HotStoneFigure;
import hotstone.view.figure.HotStoneFigureType;
import hotstone.view.tool.UsePowerTool;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.NullTool;
import java.awt.event.MouseEvent;


public class UsePowerTool extends NullTool {
    private DrawingEditor editor;
    private GameMutator game;

    public UsePowerTool(DrawingEditor editor, GameMutator game) {
        this.editor = editor;
        this.game = game;
    }

    @Override
  public void mouseUp(MouseEvent e, int x, int y) {
    // Find the figure just below the mouse (x,y)
    Figure figure = editor.drawing().findFigure(x,y);
    // Bail out fast, if there is none
    if (figure == null) {
      System.out.println("No Hero below your (x,y) = ("
              + x + ", " + y + ")");
      return;
    }
    // Bail out if figure is NOT a HotStoneFigure
    if (! (figure instanceof HotStoneFigure)) {
      System.out.println("Hm? A figure that is not a hot stone figure?");
      return;
    }

    // Bail out if figure is NOT a HeroFigure
    HotStoneFigureType type = ((HotStoneFigure)figure).getType();
    if (type != HotStoneFigureType.HERO_FIGURE) {
      System.out.println("Not a hero, the type was: " + type);
      return;
    }
    
    // We are now safe to cast and get the associated hero
    HeroFigure myHeroFigure = (HeroFigure)figure;
    Hero hero = myHeroFigure.getAssociatedHero();
    game.usePower(hero.getOwner());
    System.out.println("Hero did use power");
    // and can modify its state and tell the figure to update
  }
}
