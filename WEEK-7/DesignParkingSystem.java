class ParkingSystem {
    int[] spaces;
    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[4]; // index 1,2,3
        spaces[1] = big;
        spaces[2] = medium;
        spaces[3] = small;
    }
    public boolean addCar(int carType) {
        if (spaces[carType] > 0) {
            spaces[carType]--;
            return true;
        }
        return false;
    }
}
