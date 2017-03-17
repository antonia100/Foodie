import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Foodie implements Runnable{
    private Display display;
    private LocalDate date;
    private File logsFile, foodsFile;

    public Foodie(){
        display = new Display();
        logsFile = new File("src/res/logs.txt");
        foodsFile = new File("src/res/foods.txt");
    }

    @Override
    public void run() {
        date = LocalDate.now();
        fillDate();
        addNewFoodListener();
        addNewEntryListener();
        calcTotalCals();
    }

//___________________________________________________________________________
//      CALCULATE TOTAL CALORIES
    private void calcTotalCals(){

        double totalCals = 0;

        try(FileInputStream fis = new FileInputStream(logsFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {

            String line = reader.readLine();

            while (line!=null) {

                String[] tokens = line.split("\\|");

                if (tokens[0].equals(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date)) &&
                        tokens.length!=1) {
                    totalCals += Double.valueOf(tokens[3]);
                }

                line = reader.readLine();
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }

        display.getTotalLabel().setText("Total: " + totalCals);
    }

//___________________________________________________________________________
//      CALCULATE CALORIES FOR EACH ENTRY
    private double caloriesPerEntry(String name, int grams){

        double result = 0;

        try(FileInputStream fis = new FileInputStream(foodsFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {

            String line = reader.readLine();

            while(line!=null){
                String [] tokens = line.split("\\|");

                if(tokens[0].equals(name)){
                    int cals = Integer.parseInt(tokens[2]);
                    result = (double) grams/100 * cals;
                    break;
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


//___________________________________________________________________________
//      ADD NEW LOG TO LOGS FILE
    private void addNewEntryListener(){
        display.getNewEntryBtn().addActionListener((ActionEvent event) -> {

            if(foodExists(display.getFoodNameEntry().getText())){
                String entryToWrte = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date) + "|"  +
                        display.getFoodNameEntry().getText() + "|" +
                        display.getGramsFieldEntry().getText() + "|" +
                        caloriesPerEntry(display.getFoodNameEntry().getText(),
                                Integer.valueOf(display.getGramsFieldEntry().getText())) + "\n";
                writeToFile(logsFile, entryToWrte);
            }

            display.getFoodNameEntry().setText("");
            display.getGramsFieldEntry().setText("");

            calcTotalCals();

        });
    }


//__________________________________________________________________________
//      FUNCTION TO WRITE TO FILE
    private void writeToFile(File file, String input){
        try(FileOutputStream fos = new FileOutputStream(file, true)){

            byte[] inputBytes = input.getBytes();
            fos.write(inputBytes);

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

//___________________________________________________________________________
//      ADD DATE TO DISPLAY
        private void fillDate(){
        String dateStr = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date);
        display.getDateLabel().setText("Date: " + dateStr);
    }

//___________________________________________________________________________
        //ADD NEW FOOD TO FOODS FILE
private void addNewFoodListener(){
        display.getAddNewFoodBtn().addActionListener((ActionEvent event) -> {
            String name = display.getFoodName().getText();
            int calsPer100 = Integer.valueOf(display.getGramsField().getText());

            if(!foodExists(name)) {
                FoodItem newFood = new FoodItem(name, calsPer100);
            }
            display.getFoodName().setText("");
            display.getGramsField().setText("");
        });
    }

    private boolean foodExists(String name){

        try(FileInputStream fis = new FileInputStream(foodsFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {

            String line = reader.readLine();

            while(line!=null){
                String [] tokens = line.split("\\|");

                if(tokens[0].equals(name)){
                    return true;
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

//_________________________________________________________________________________________
//         ADD LOGS WINDOW
}
