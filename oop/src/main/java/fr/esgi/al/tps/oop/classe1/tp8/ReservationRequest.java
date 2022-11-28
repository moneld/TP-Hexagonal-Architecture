package fr.esgi.al.tps.oop.classe1.tp8;

final class ReservationRequest {

    private final int numberOfRooms;
    private final int numberOfAdults;
    private final int numberOfChildren;

    public ReservationRequest(int numberOfRooms, int numberOfAdults, int numberOfChildren) {
        if (numberOfChildren + numberOfAdults > numberOfRooms) {
            throw new ReservationException("Can't book more rooms than occupants.");
        }
        this.numberOfRooms = numberOfRooms;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;

    }
}
