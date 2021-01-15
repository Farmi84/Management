import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;
import exception.*;
import facade.UserRegisterLoginFacadeImpl;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void loggedMenu() {
        boolean logged = true;
        while(logged) {
            System.out.println("MANAGEMENT MENU");
            System.out.println("1 - Dodaj nowy product");
            System.out.println("0 - Wyloguj się");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            String emptyLine = scanner.nextLine();

            switch (a){
                case 1:
                    productTypeMenu();
                    break;
                case 0:
                    logged = false;
                    break;
                default:
                    System.out.println("Zły numer");
            }
        }
    }

    public static void productTypeMenu() {
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String emptyLine = scanner.nextLine();
        System.out.println("Podaj id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj nazwę produktu: ");
        String productName = scanner.nextLine();
        System.out.println("Podaj cenę: ");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.println("Podaj masę: ");
        float weight = Float.parseFloat(scanner.nextLine());
        System.out.println("Podaj kolor: ");
        String color = scanner.nextLine();
        System.out.println("Podaj ilość: ");
        int productCount = Integer.parseInt(scanner.nextLine());


        switch (a){
            case 1:
                System.out.println("Podaj rozmiar: ");
                int sizeInt = Integer.parseInt(scanner.nextLine());
                System.out.println("Czy buty są skórzane? (Y/N)");
                String isNaturalSkinString = scanner.nextLine();
                boolean isNaturalSkin = false; //sprawdzić
                if(isNaturalSkinString.equals("Y")){
                     isNaturalSkin = true;
                } else if(isNaturalSkinString.equals("N")) {
                    isNaturalSkin = false;
                }

                Product boots = new Boots(id, productName, price, weight, color, productCount, sizeInt, isNaturalSkin);


                    if(ProductServiceImpl.getInstance().saveProduct(boots)){
                        System.out.println("Dodano pomyślnie buty.");
                    } else{
                        System.out.println("Błąd w dodawaniu butów.");
                    }

                break;
            case 2:
                System.out.println("Podaj rozmiar: ");
                String sizeString = scanner.nextLine();
                System.out.println("Podaj rodzaj materiału: ");
                String material = scanner.nextLine();
                Product cloth = new Cloth(id, productName, price, weight, color, productCount, sizeString, material);

                    if(ProductServiceImpl.getInstance().saveProduct(cloth)){
                        System.out.println("Dodano pomyślnie ubranie.");
                    } else{
                        System.out.println("Błąd w dodawaniu ubrania.");
                    }

                break;
            case 3:
                Product product = new Product(id, productName, price, weight, color, productCount);

                    if(ProductServiceImpl.getInstance().saveProduct(product)){
                        System.out.println("Dodano pomyślnie produkt");
                    } else{
                        System.out.println("Błąd w dodawaniu produktu");
                    }

                    break;

            default:
                System.out.println("Zły numer");
        }
    }






    public static void main(String[] args) {
        boolean mainMenu = true;

        while (mainMenu) {
            System.out.println("MANAGEMENT MENU");
            System.out.println("1 - Zaloguj się");
            System.out.println("2 - Zarejestruj się");
            System.out.println("0 - Wyjdź");

            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            String s = scanner.nextLine();

            switch (a){
                case 1:
                    System.out.println("Login:");
                    String login = scanner.nextLine();
                    System.out.println("Hasło:");
                    String password = scanner.nextLine();
                    if(UserRegisterLoginFacadeImpl.getInstance().loginUser(login, password)){
                        System.out.println("zalogowano" + "\n");
                    loggedMenu();
                    }
                    break;
                case 2:
                    System.out.println("Podaj nowy login");
                    String newLogin = scanner.nextLine();
                    System.out.println("Podaj hasło");
                    String newPassword = scanner.nextLine();
                    System.out.println("id");
                    long id = scanner.nextInt();
                    String empty = scanner.nextLine();
                    try {
                        if(UserRegisterLoginFacadeImpl.getInstance().registerUser(new User(id, newLogin, newPassword))){
                            System.out.println("Rejestracja przebiegła pomyślnie");
                        } else {
                            System.out.println("Błąd rejestracji");
                        }
                        break;
                    } catch (UserLoginAlreadyExistException e) {
                        e.printStackTrace();
                    } catch (UserShortLengthPasswordException e) {
                        e.printStackTrace();
                    } catch (UserShortLengthLoginException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case 0:
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Zły numer");
            }
        }
    }
}
