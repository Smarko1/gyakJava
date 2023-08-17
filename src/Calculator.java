import java.util.List;

public class Calculator {
    static int calculatePrice(List<Pairs> products, String[] selectedProducts) {
        int totalPrice = 0;
        int aCount = 0;
        int cCount = 0;
        int dCount = 0;
        boolean ECombo = false;
        boolean DCombo = false;

        for (String product : selectedProducts) {
            for (Pairs p : products) {
                if (p.getName().equalsIgnoreCase(product)) {

                    if(product.equalsIgnoreCase("A")){
                        aCount++;
                    }

                    if (product.equalsIgnoreCase("C")) {
                        cCount++;
                        if (cCount == 1 && aCount == 2) {
                            totalPrice -= p.getPrice() / 2;
                        }
                    }

                    if (product.equalsIgnoreCase("D")) {
                        dCount++;
                        if (dCount % 3 == 0) {
                            totalPrice -= p.getPrice();
                        }
                        DCombo = true;
                    }

                    if (product.equalsIgnoreCase("E")) {
                        ECombo = true;
                    }

                    totalPrice += p.getPrice();
                }
            }
        }
        if (ECombo && DCombo) {
            totalPrice *= 1.3;
        }

        return rounding(totalPrice);
    }

    private static int rounding(int totalPrice){
        totalPrice = (int) Math.ceil(totalPrice);
        totalPrice = ((totalPrice + 4) / 5)*5;
        return totalPrice;
    }
}
