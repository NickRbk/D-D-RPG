package cursor.rybak.model.maze.compass;

import cursor.rybak.model.maze.LineTypes;
import cursor.rybak.model.maze.Location;

import java.util.List;

public interface Compass {
    default void moveStraightCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if (LineTypes.lineTypeA.equals(currentLocation.getMainLineType())) {
            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine( ListUtil.reverse( lineA ) );
                newLocation.setCrossLine( ListUtil.reverse( lineB ) );
            } else {
                newLocation.setMainLine(lineA);
                newLocation.setCrossLine(lineB);
            }
        } else {
            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineB));
                newLocation.setCrossLine(lineA);
            } else {
                newLocation.setMainLine(lineB);
                newLocation.setCrossLine(ListUtil.reverse(lineA));
            }
        }

        newLocation.setMainLineType( currentLocation.getMainLineType() );
        newLocation.setMainReverse( currentLocation.isMainReverse() );
    }

    default void moveBackCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if (LineTypes.lineTypeA.equals(currentLocation.getMainLineType())) {
            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(lineA);
                newLocation.setCrossLine(lineB);
            } else {
                newLocation.setMainLine( ListUtil.reverse( lineA ) );
                newLocation.setCrossLine( ListUtil.reverse( lineB ) );
            }
        } else {
            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(lineB);
                newLocation.setCrossLine( ListUtil.reverse(lineA) );
            } else {
                newLocation.setMainLine( ListUtil.reverse(lineB) );
                newLocation.setCrossLine(lineA);
            }
        }

        newLocation.setMainLineType( currentLocation.getMainLineType() );
        newLocation.setMainReverse( !currentLocation.isMainReverse() );
    }

    default void moveRightCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if (LineTypes.lineTypeA.equals(currentLocation.getMainLineType())) {
            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineB));
                newLocation.setCrossLine(lineA);
                newLocation.setMainReverse(true);
            } else {
                newLocation.setMainLine(lineB);
                newLocation.setCrossLine(ListUtil.reverse(lineB));
                newLocation.setMainReverse(false);
            }

            newLocation.setMainLineType( LineTypes.lineTypeB );
        } else {
            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(lineA);
                newLocation.setCrossLine(lineB);
                newLocation.setMainReverse(false);
            } else {
                newLocation.setMainLine(ListUtil.reverse(lineA));
                newLocation.setCrossLine(ListUtil.reverse(lineB));
                newLocation.setMainReverse(true);
            }

            newLocation.setMainLineType( LineTypes.lineTypeA );
        }
    }

    default void moveLeftCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if(LineTypes.lineTypeA.equals(currentLocation.getMainLineType())) {
            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(lineB);
                newLocation.setCrossLine( ListUtil.reverse(lineA));
                newLocation.setMainReverse(false);
            } else {
                newLocation.setMainLine(ListUtil.reverse(lineB));
                newLocation.setCrossLine(lineA);
                newLocation.setMainReverse(true);
            }

            newLocation.setMainLineType( LineTypes.lineTypeB );
        } else {
            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineA));
                newLocation.setCrossLine(ListUtil.reverse(lineB));
                newLocation.setMainReverse(true);
            } else {
                newLocation.setMainLine(lineA);
                newLocation.setCrossLine(lineB);
                newLocation.setMainReverse(false);
            }

            newLocation.setMainLineType( LineTypes.lineTypeA );
        }
    }
}
