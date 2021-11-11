package normalisation;

public class normalisationCodePost {
    public static String normalisation(String str) {

        if (str != null) {
            str = str.trim();

            if (str.contains("L-")) {
                str = str.replace("L-", "");
            } else if (str.length() == 4) {

                char zero = '0';
                str = zero + str;

            }

        }


        return str;

    }

}
