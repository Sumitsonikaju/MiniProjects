package Mini_Projects;

import java.util.Scanner;

public class Atlas {

    public static void main(String[] args) {
        String[] countriesArray = {
                "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda",
                "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain",
                "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia",
                "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso",
                "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic",
                "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Costa Rica", "Croatia",
                "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
                "East Timor", "Timor Leste", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
                "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia",
                "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
                "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland",
                "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya",
                "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait",
                "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein",
                "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta",
                "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco",
                "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Burma", "Namibia", "Nauru",
                "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Macedonia",
                "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
                "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis",
                "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe",
                "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia",
                "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka",
                "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania",
                "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu",
                "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan",
                "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"
        };

        String[] usedCountries = new String[195];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Country Game!");
        String currentCountry = getRandomCountry(countriesArray);
        System.out.println("Starting country: " + currentCountry);

        boolean player1Turn = true; // Player 1 starts
        while (true) {
            String lastChar = getLastCharacter(currentCountry);

            String playerName = player1Turn ? "Player 1" : "Player 2";
            System.out.print(playerName + ", enter a country starting with '" + lastChar + "': ");
            String guessedCountry = scanner.nextLine();

            if (!isCountryValid(guessedCountry, countriesArray) || !startsWithLastCharacter(guessedCountry, lastChar)) {
                System.out.println("Invalid country! " + playerName + " loses.");
                break;
            }

            // Check if the country has already been used
            if (!isCountryUnused(guessedCountry, usedCountries)) {
                System.out.println("Country already used! " + playerName + " loses.");
                break;
            }
            markCountryUsed(guessedCountry, usedCountries);


            System.out.println("Correct!");
            currentCountry = guessedCountry;
            player1Turn = !player1Turn; // Switch turns
        }
        scanner.close();
    }

    private static String getRandomCountry(String[] countriesArray) {
        int randomIndex = (int) (Math.random() * countriesArray.length);
        return countriesArray[randomIndex];
    }

    private static String getLastCharacter(String str) {
        return str.substring(str.length() - 1);
    }

    private static boolean isCountryValid(String country, String[] countriesArray) {
        for (String c : countriesArray) {
            if (c.equalsIgnoreCase(country)) {
                return true;
            }
        }
        return false;
    }

    private static boolean startsWithLastCharacter(String country, String lastChar) {
        return country.trim().toLowerCase().startsWith(lastChar.toLowerCase());
    }

    private static void markCountryUsed(String country, String[] usedCountries) {
        for (int i = 0; i < usedCountries.length; i++) {
            if (usedCountries[i] == null) {
                usedCountries[i] = country;
                break;
            }
        }
    }
    
    private static boolean isCountryUnused(String country, String[] usedCountries) {
        for (String usedCountry : usedCountries) {
            if (usedCountry != null && usedCountry.equalsIgnoreCase(country)) {
                return false; // Country already used
            }
        }
        return true; // Country is unused
    }
    
    

}
