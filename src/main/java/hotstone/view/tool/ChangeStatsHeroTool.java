package hotstone.view.tool;

import org.w3c.dom.events.MouseEvent;

import hotstone.framework.Game;
import hotstone.framework.Hero;
import hotstone.framework.Player;
import hotstone.view.figure.HeroFigure;
import hotstone.view.figure.HotStoneFigure;
import hotstone.view.figure.HotStoneFigureType;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.NullTool;
import hotstone.standard.hero.HeroMutator;
public class ChangeStatsHeroTool extends NullTool {
    private DrawingEditor editor;
    private Player whoAmIPlaying;
    private Game game;

    public ChangeStatsHeroTool(DrawingEditor editor, Game game, Player whoAmIPlaying) {
  
      this.editor = editor;
      this.game = game;
      this.whoAmIPlaying = whoAmIPlaying;      
    }

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
      HeroMutator hero = (HeroMutator) myHeroFigure.getAssociatedHero();
      System.out.println("This is a hero");
    }
}
