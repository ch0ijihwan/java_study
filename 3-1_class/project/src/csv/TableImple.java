package csv;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class TableImple implements Table{

    List<ColumnImple> Columns = new ArrayList<ColumnImple>();
    boolean Head_line =false;

    String change_String(String line){
        String new_line = "";
        try {
            new_line = line.substring(line.indexOf("\""), line.lastIndexOf("\"") + 1);

            new_line = new_line.replace(',', '|');

            new_line = (line.substring(0, line.indexOf("\"")) + new_line + line.substring(line.lastIndexOf("\"") + 1, line.length()));
            return new_line;
        }
        catch (StringIndexOutOfBoundsException e){
            return line;
        }

    }

    public String toString(){
        System.out.println("<해쉬코드>");
        int Data_length = Columns.get(0).count();
        int Columns_length = Columns.size();
        int int_cnt =0, double_cnt =0, String_cnt =0;

        System.out.println("RangeIndex: "+Data_length + "entries 0 to " + (Data_length-1));
        System.out.println("Data columns (total "+Columns_length + " columns):" );
        System.out.printf("%3s | %12s | %17s | %s\n", "#", "Column","Non-Null Count", "Dtype");

        for(int i=0; i<Columns.size(); i++) {
            String header_info = Columns.get(i).getHeader();
            long non_null_cnt =Columns.get(i).Data.size()- Columns.get(i).getNullCount();
            String Dtype = Columns.get(i).checkDtype();

            if(Dtype == "int") int_cnt++;
            else if(Dtype == "double") double_cnt++;
            else String_cnt++;

            String non_null = Long.toString(non_null_cnt);
            System.out.printf("%3s | %12s | %17s | %s\n", i, header_info, non_null+"Non-Null Count",Dtype);
        }

        System.out.println("dtypes: double("+ double_cnt+"), int("+ int_cnt+"), String("+ String_cnt+")");

        return "";
    }


    //========================================= 문제 3 ========================================//

    @Override
    public void print() {
        if(this.Head_line == true) {
            for (int i = 0; i < Columns.size(); i++) {
                Columns.get(i).print_Head(i);
            }
            System.out.println();
        }

        for(int i=0; i<Columns.get(0).Data.size(); i++){
            for(int j=0; j<Columns.size(); j++) {
                Columns.get(j).print(i);
            }
            System.out.println();
        }
    }

    //========================================= 문제 4 ========================================//

    @Override
    public Table getStats() {

        return null;
    }

    @Override
    public Table head() {
        TableImple new_Table = new TableImple();

        if(Head_line == true) new_Table.Head_line = true;
        else new_Table.Head_line =false;

        for(int i=0; i<Columns.size(); i++){
            ColumnImple c = new ColumnImple();
            c.Header = Columns.get(i).getHeader();
            for(int j= 0; j<5; j++) {
                try {
                    c.Data.add(new String(Columns.get(i).getValue(j)));
                }
                catch (NullPointerException e){
                    c.Data.add(null);
                }
            }
            new_Table.Columns.add(c);
        }

        return new_Table;
    }

    @Override
    public Table head(int lineCount) {
        TableImple new_Table = new TableImple();

        if(Head_line == true) new_Table.Head_line = true;
        else new_Table.Head_line =false;

        for(int i=0; i<Columns.size(); i++){
            ColumnImple c = new ColumnImple();
            c.Header = Columns.get(i).getHeader();
            for(int j= 0; j<lineCount; j++) {
                try {
                    c.Data.add(new String(Columns.get(i).getValue(j)));
                }
                catch (NullPointerException e){
                    c.Data.add(null);
                }
            }
            new_Table.Columns.add(c);
        }

        return new_Table;
    }

    @Override
    public Table tail() {
        TableImple new_Table = new TableImple();

        if(Head_line == true) new_Table.Head_line = true;
        else new_Table.Head_line =false;

        for(int i=0; i<Columns.size(); i++){
            ColumnImple c = new ColumnImple();
            c.Header = Columns.get(i).getHeader();
            for(int j= Columns.get(i).count()-5; j<Columns.get(i).count(); j++) {
                try {
                    c.Data.add(new String(Columns.get(i).getValue(j)));
                }
                catch (NullPointerException e){
                    c.Data.add(null);
                }
            }
            new_Table.Columns.add(c);
        }

        return new_Table;
    }

    @Override
    public Table tail(int lineCount) {
        TableImple new_Table = new TableImple();

        if (Head_line == true) new_Table.Head_line = true;
        else new_Table.Head_line = false;

        for (int i = 0; i < Columns.size(); i++) {
            ColumnImple c = new ColumnImple();
            c.Header = Columns.get(i).getHeader();
            for (int j = Columns.get(i).count() - lineCount; j < Columns.get(i).count(); j++) {
                try {
                    c.Data.add(new String(Columns.get(i).getValue(j)));
                } catch (NullPointerException e) {
                    c.Data.add(null);
                }
            }
            new_Table.Columns.add(c);
        }

        return new_Table;
    }

    @Override
    public Table selectRows(int beginIndex, int endIndex) {
        TableImple new_Table = new TableImple();

        if(Head_line == true) new_Table.Head_line = true;
        else new_Table.Head_line =false;

        for(int i=0; i<Columns.size(); i++){
            ColumnImple c = new ColumnImple();
            c.Header = Columns.get(i).getHeader();
            for(int j= beginIndex; j<endIndex; j++) {
                try {
                    c.Data.add(new String(Columns.get(i).getValue(j)));
                }
                catch (NullPointerException e){
                    c.Data.add(null);
                }
            }
            new_Table.Columns.add(c);
        }

        return new_Table;
    }

    @Override
    public Table selectRowsAt(int... indices) {
        TableImple new_Table = new TableImple();

        if(Head_line == true) new_Table.Head_line = true;
        else new_Table.Head_line =false;

        for(int i=0; i<Columns.size(); i++){
            ColumnImple c = new ColumnImple();
            c.Header = Columns.get(i).getHeader();
            for(int j : indices) {
                try {
                    c.Data.add(new String(Columns.get(i).getValue(j)));
                }
                catch (NullPointerException e){
                    c.Data.add(null);
                }
            }
            new_Table.Columns.add(c);
        }

        return new_Table;
    }

    @Override
    public Table selectColumns(int beginIndex, int endIndex) {
        TableImple new_Table = new TableImple();

        if(Head_line == true) new_Table.Head_line = true;
        else new_Table.Head_line =false;

        for(int i=beginIndex; i<endIndex; i++){
            ColumnImple c = new ColumnImple();
            c.Header = Columns.get(i).getHeader();
            for(int j= 0; j<Columns.get(i).count(); j++) {
                try {
                    c.Data.add(new String(Columns.get(i).getValue(j)));
                }
                catch (NullPointerException e){
                    c.Data.add(null);
                }
            }
            new_Table.Columns.add(c);
        }

        return new_Table;
    }

    @Override
    public Table selectColumnsAt(int... indices) {
        TableImple new_Table = new TableImple();

        if(Head_line == true) new_Table.Head_line = true;
        else new_Table.Head_line =false;

        for(int i : indices){
            ColumnImple c = new ColumnImple();
            c.Header = Columns.get(i).getHeader();
            for(int j= 0; j<Columns.get(i).count(); j++) {
                try {
                    c.Data.add(new String(Columns.get(i).getValue(j)));
                }
                catch (NullPointerException e){
                    c.Data.add(null);
                }
            }
            new_Table.Columns.add(c);
        }

        return new_Table;
    }

    @Override
    public <T> Table selectRowsBy(String columnName, Predicate<T> predicate) {
        return null;
    }

    @Override
    public Table sort(int byIndexOfColumn, boolean isAscending, boolean isNullFirst) {

        if(Columns.get(byIndexOfColumn).checkDtype().equals("int"))
            Columns.get(byIndexOfColumn).sort_int(isAscending, isNullFirst);
        else if(Columns.get(byIndexOfColumn).checkDtype().equals("double"))
            Columns.get(byIndexOfColumn).sort_double(isAscending, isNullFirst);
        else
            Columns.get(byIndexOfColumn).sort_String(isAscending, isNullFirst);

        return this;
    }

    @Override
    public Table shuffle() {
        Random random = new Random();
        Boolean[] checker = new Boolean[Columns.get(0).count()];
        Boolean END = false;
        for(int i=0; i<checker.length; i++) checker[i]=false;

        while(true){
            if(END== true) break;

            END =true;

            for(int i=0; i<checker.length; i++){
                if(checker[i] == false){
                    END = false;
                    break;
                }
            }

            int number = random.nextInt(Columns.get(0).count());
            int number_2 = random.nextInt(Columns.get(0).count());

            if(checker[number] == true || checker[number_2]== true) continue;

            for (int i = 0; i < Columns.size(); i++) {
                checker[number] =true;
                checker[number_2] = true;
                String value = Columns.get(i).getValue(number_2);
                String value_2 = Columns.get(i).getValue(number);
                Columns.get(i).setValue(number, value);
                Columns.get(i).setValue(number_2, value);
            }
        }
        return this;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return this.Columns.size();
    }

    @Override
    public Column getColumn(int index) {
        return this.Columns.get(index);
    }

    @Override
    public Column getColumn(String name) {
        return null;
    }

    @Override
    public boolean fillNullWithMean() {
        Boolean[] checker = new Boolean[Columns.size()];

        for(int i=0; i<checker.length; i++) checker[i] = false;

        for(int i=0; i<Columns.size(); i++){
            checker[i] = Columns.get(i).fillNullWithMean();
        }

        for(int i=0; i<checker.length; i++){
            if(checker[i] == true){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean fillNullWithZero() {
        Boolean[] checker = new Boolean[Columns.size()];

        for(int i=0; i<checker.length; i++) checker[i] = false;

        for(int i=0; i<Columns.size(); i++){
            checker[i] = Columns.get(i).fillNullWithZero();
        }

        for(int i=0; i<checker.length; i++){
            if(checker[i] == true){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean standardize() {
        Boolean[] checker = new Boolean[Columns.size()];

        for(int i=0; i<checker.length; i++) checker[i] = false;

        for(int i=0; i<Columns.size(); i++){
            checker[i] = Columns.get(i).standardize();
        }

        for(int i=0; i<checker.length; i++){
            if(checker[i] == true){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean normalize() {
        Boolean[] checker = new Boolean[Columns.size()];

        for(int i=0; i<checker.length; i++) checker[i] = false;

        for(int i=0; i<Columns.size(); i++){
            checker[i] = Columns.get(i).normalize();
        }

        for(int i=0; i<checker.length; i++){
            if(checker[i] == true){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean factorize() {
        Boolean[] checker = new Boolean[Columns.size()];

        for(int i=0; i<checker.length; i++) checker[i] = false;

        for(int i=0; i<Columns.size(); i++){
            checker[i] = Columns.get(i).factorize();
        }

        for(int i=0; i<checker.length; i++){
            if(checker[i] == true){
                return true;
            }
        }
        return false;
    }
}
