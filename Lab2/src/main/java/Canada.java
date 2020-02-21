public class Canada {

    private static final int MILLION_CONVERTER = 1_000_000;

    private Province[] provinces;


    public Canada(){
        provinces = new Province[10];
        long[] pop = {13_338_494,8_164_361,971_395,747_101,1_278_365,4_648_055,142_907,1_098_352,4_067_175,519_716};
        Province province;
        for (int i = 0; i < provinces.length; i++){
            province = new Province(Province.provinces.get(i),Province.capitals.get(i),pop[i]);
            provinces[i] = province;
        }
    }

    public void displayAllProvinces(){
       // which loops through the array and prints each Province object’s getDetails() method. Note: Use for-each loop.
        for (Province p : provinces)
            System.out.println(p.getDetails());
    }

    public int getNumOfProvincesBetween(int min, int max) {

        // which takes the population in millions (e.g. 4, 6)and returns the number of Provinces with the populations in
        // that range (e.g. 4 - 6 million, inclusive).Note: Use for -each loop.
        int count = 0;
        for ( Province p : provinces ) {
            if (p.getPopulation() >= (min * MILLION_CONVERTER) && p.getPopulation() <= (max * MILLION_CONVERTER))
                count ++;
        }
        return count;
    }


}
