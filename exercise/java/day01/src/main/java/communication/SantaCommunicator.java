package communication;

public class SantaCommunicator {
    private final int numberOfDaysToRest;

    public SantaCommunicator(int numberOfDaysToRest) {
        this.numberOfDaysToRest = numberOfDaysToRest;
    }

    public String composeMessage(Reindeer reindeer, int numberOfDaysBeforeChristmas) {
        var daysBeforeReturn = daysBeforeReturn(reindeer.numbersOfDaysForComingBack(), numberOfDaysBeforeChristmas);

        return "Dear " + reindeer.reindeerName() + ", please return from " + reindeer.currentLocation() +
                " in " + daysBeforeReturn + " day(s) to be ready and rest before Christmas.";
    }

    public boolean isOverdue(Reindeer reindeer, int numberOfDaysBeforeChristmas, Logger logger) {
        if (daysBeforeReturn(reindeer.numbersOfDaysForComingBack(), numberOfDaysBeforeChristmas) <= 0) {
            logger.log("Overdue for " + reindeer.reindeerName() + " located " + reindeer.currentLocation() + ".");
            return true;
        }
        return false;
    }

    private int daysBeforeReturn(int numbersOfDaysForComingBack, int numberOfDaysBeforeChristmas) {
        return numberOfDaysBeforeChristmas - numbersOfDaysForComingBack - numberOfDaysToRest;
    }
}