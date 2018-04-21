package cursor.rybak.model.maze.compass;

import cursor.rybak.model.maze.Location;

import java.util.List;

public interface Compass {
    default void moveStraightCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        if (lineA.indexOf(currentLocation) != -1) {

            if (!currentLocation.isMainReverse()) newLocation.setMainLine(lineA);
            else newLocation.setMainLine(ListUtil.reverse(lineA));

        } else {

            if (!currentLocation.isMainReverse()) newLocation.setCrossLine(lineB);
            else newLocation.setCrossLine(ListUtil.reverse(lineB));

        }

    }

    default void moveBackCompass(Location currentLocation, Location newLocation) {
        List<Location> lineA = ListUtil.copy(newLocation.getLineA());
        List<Location> lineB = ListUtil.copy(newLocation.getLineB());

        currentLocation.setMainReverse( !currentLocation.isMainReverse() );

        if (lineA.indexOf(currentLocation) != -1) {

            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineA));
            } else newLocation.setMainLine(lineA);

        } else {

            if(currentLocation.isMainReverse()) {
                newLocation.setMainLine(ListUtil.reverse(lineB));
            } else newLocation.setMainLine(lineB);

        }
    }

    default void moveRightCompass() {

    }

    default void moveLeftCompass() {

    }


//    default void moveOnOrdinalWay(Location currentLocation, Location newLocation) {
//        List<Location> lineA = newLocation.getLineA();
//        List<Location> lineB = newLocation.getLineB();
//
//
//        if(lineB.indexOf(currentLocation) != -1) {
//
//            if(currentLocation.isMainReverse()) {
//                newLocation.setMainLine( lineB.subList(0, lineB.size()) );
//                newLocation.setCrossLine( ReverseList.reverse( lineA.subList(0, lineA.size()) ) );
//            } else {
//                newLocation.setMainLine( ReverseList.reverse( lineB.subList(0, lineB.size()) ) );
//                newLocation.setCrossLine( ReverseList.reverse( lineA.subList(0, lineA.size()) ) );
//            }
//
//        } else {
//            newLocation.setMainLine( lineA.subList(0, lineA.size()) );
//            newLocation.setCrossLine( ReverseList.reverse( lineB.subList(0, lineB.size()) ) );
//        }
//
//        if(lineB.indexOf(currentLocation) == -1) {
//
//            newLocation.setMainLine( lineB.subList(0, lineB.size()) );
//            newLocation.setCrossLine( lineA.subList(0, lineA.size()) );
//        } else {
//            newLocation.setMainLine( lineA.subList(0, lineA.size()) );
//            newLocation.setCrossLine( lineB.subList(0, lineB.size()) );
//        }
//
//
//
//
//
//        if(lineB.indexOf(currentLocation) != -1) {
//
//            newLocation.setMainLine( lineB.subList(0, lineB.size()) );
//            newLocation.setCrossLine( ReverseList.reverse( lineA.subList(0, lineA.size()) ) );
//        } else {
////            if(newLocation.isMainReverse()) {
////                newLocation.setMainLine( lineA.subList(0, lineA.size()) );
////            } else {
////                newLocation.setMainLine( ReverseList.reverse( lineA.subList(0, lineA.size()) ) );
////            }
//
//            newLocation.setMainLine( lineA.subList(0, lineA.size()) );
//            newLocation.setCrossLine( lineB.subList(0, lineB.size()) );
//        }
//    }
//
//    default void moveOnReverseWay(Location currentLocation, Location newLocation) {
//        List<Location> lineA = newLocation.getLineA();
//        List<Location> lineB = newLocation.getLineB();
//
//        if(lineB.indexOf(currentLocation) != -1) {
//            newLocation.setMainLine(ReverseList.reverse( lineB.subList(0, lineB.size()) ) );
//            newLocation.setCrossLine( lineA.subList(0, lineA.size()) );
//        } else {
//            newLocation.setMainLine( ReverseList.reverse( lineA.subList(0, lineA.size()) ) );
//            newLocation.setCrossLine( ReverseList.reverse( lineB.subList(0, lineB.size()) ) );
////            newLocation.setMainReverse(true);
//        }
//    }
}
