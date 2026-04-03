class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Integer[]> cars = new ArrayList<>(); //position, speed
        for(int i=0; i<position.length; i++) {
            cars.add(new Integer[]{position[i], speed[i]});
        }

        cars.sort((a, b) -> b[0] - a[0]);
        // cars.stream().forEach(car -> System.out.printf("p %d, s %d\n", car[0], car[1]));

        int carFleets = 0;
        double maxHops = 0;
        for(Integer[] car : cars) {
            double hops = (double) (target - car[0]) / car[1];
            // System.out.printf("p %d, s %d, h %d\n", car[0], car[1], hops);
            if(hops > maxHops) {
                maxHops = hops;
                carFleets++;
            }
        }

        return carFleets;
    }
}


// 0, 1, 4, 7

// 1, 2, 2, 1

/*
    hops = (target / speed) - position

    hops sorted by positioning descending 3, 2, 2, 6
    if(hop[i+1] > maxHop[i]) fleet++

    [7,1] = (10 / 1) - 7 = 3 
    [4, 2] = (10 / 2) - 4 = 2
    [1, 2] = (10 / 2) - 4 = 2
    [0, 1] = (10 / 1) - 4 = 6

    [4, 2] = (10 - 4) / 2 = 3
    [1, 3] = (10 - 1) / 3 = 3 
*/