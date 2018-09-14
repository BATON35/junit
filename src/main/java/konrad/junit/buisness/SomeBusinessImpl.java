package konrad.junit.buisness;

import lombok.Data;

@Data
class SomeBusinessImpl {


    private SomeDataService someDataService;

    int calculateSum(int... data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    int calculateSumUsingSomeDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }
}
