/*
 * Copyright (C) 2022. Henrik Bærbak Christensen, Aarhus University.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package hotstone.main;

import hotstone.figuretestcase.doubles.FakeObjectGame;
import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.standard.factories.AlphaStoneFactory;
import hotstone.standard.factories.BetaStoneFactory;
import hotstone.standard.factories.DeltaStoneFactory;
import hotstone.standard.factories.EtaStoneFactory;
import hotstone.standard.factories.GammaStoneFactory;
import hotstone.standard.game.StandardHotStoneGame;
import hotstone.view.core.HotStoneDrawingType;
import hotstone.view.core.HotStoneFactory;
import hotstone.view.tool.HotSeatStateTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;
import minidraw.standard.SelectionTool;

/** A single jvm application which uses a 'hotseat' to allow both players to
 * alternate play.
 */
public class HotSeatStone {
  public static void main(String[] args) {

    System.out.println("=== Starting HotSeat on game variant: " + args[0] + " ===");
    // TODO: Do some switching on args[0] to make the right game variant
    Game game = new FakeObjectGame();
    switch(args[0]){
      case "alpha":
      game = new StandardHotStoneGame(new AlphaStoneFactory());
      break;
      case "beta":
      game = new StandardHotStoneGame(new BetaStoneFactory());
      break;  
      case "delta":
      game = new StandardHotStoneGame(new DeltaStoneFactory());
      break;    
      case "epsilon":
      game = new StandardHotStoneGame(new EtaStoneFactory());
      break;  
      case "gamma":
      game = new StandardHotStoneGame(new GammaStoneFactory());
      break;    
      // default:
      // game = new FakeObjectGame();            
    }

    DrawingEditor editor =
            new MiniDrawApplication( "HotSeat: Variant " + args[0],
                    new HotStoneFactory(game, Player.FINDUS,
                            HotStoneDrawingType.HOTSEAT_MODE) );
    editor.open();
    // TODO: Change to the hotseat state tool
    editor.setTool(new HotSeatStateTool(editor, game));
  }
}
