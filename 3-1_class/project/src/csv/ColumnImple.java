package csv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColumnImple implements Column{

    List<String> Data = new ArrayList<String>();
    String Header =null;

    String checkDtype(){
        String type = "int";
        try {
            for (int i = 0; i < Data.size(); i++) {
                Integer.parseInt(Data.get(i));
            }
        } catch (NumberFormatException e){
            try{
                for(int i=0; i<Data.size(); i++){
                    try {
                        Double.parseDouble(Data.get(i));
                    } catch (NullPointerException n){

                    }
                }
                type = "double";
            }
            catch (NumberFormatException e2){
                type = "String";
            }
        }
        return type;
    }

    void sort_int(boolean A, boolean N){
        List<String> List = new ArrayList<String>();
        List<Integer> Int = new ArrayList<Integer>();

        if(A ==true){
            if(N==true){
                for(int i=0; i<Data.size(); i++){
                    try {
                        if (Data.get(i).equals(null)) {
                            List.add(null);
                            continue;
                        }
                    } catch (NullPointerException e){
                        List.add(null);
                        continue;
                    }
                    int tmp = Integer.parseInt(Data.get(i));
                    Int.add(tmp);
                }

                Collections.sort(Int);

                for(int i=0; i<Int.size(); i++){
                    List.add(Integer.toString(Int.get(i)));
                }
            }
            else{
                for(int i=0; i<Data.size(); i++){
                    try {
                        int tmp = Integer.parseInt(Data.get(i));
                        Int.add(tmp);
                    } catch (NullPointerException e){}
                }

                Collections.sort(Int);

                for(int i=0; i<Int.size(); i++){
                    List.add(Integer.toString(Int.get(i)));
                }

                for(int i=0; i<Data.size(); i++){
                    try {
                        if (Data.get(i).equals(null)) {
                            List.add(null);
                        }
                    } catch (NullPointerException e){
                        List.add(null);
                    }

                }
            }
        }
        else{
            if(N==true){
                for(int i=0; i<Data.size(); i++){
                    try {
                        if (Data.get(i).equals(null)) {
                            List.add(null);
                            continue;
                        }
                    } catch (NullPointerException e){
                        List.add(null);
                        continue;
                    }
                    int tmp = Integer.parseInt(Data.get(i));
                    Int.add(tmp);
                }

                Collections.sort(Int, Collections.reverseOrder());

                for(int i=0; i<Int.size(); i++){
                    List.add(Integer.toString(Int.get(i)));
                }
            }
            else{
                for(int i=0; i<Data.size(); i++){
                    try {
                        int tmp = Integer.parseInt(Data.get(i));
                        Int.add(tmp);
                    } catch (NullPointerException e){}
                }

                Collections.sort(Int , Collections.reverseOrder());

                for(int i=0; i<Int.size(); i++){
                    List.add(Integer.toString(Int.get(i)));
                }

                for(int i=0; i<Data.size(); i++){
                    try {
                        if (Data.get(i).equals(null)) {
                            List.add(null);
                        }
                    } catch (NullPointerException e){
                        List.add(null);
                    }
                }
            }
        }
        this.Data = List;
    }
    void sort_double(boolean A, boolean N){

    }
    void sort_String(boolean A, boolean N){
        List<String> List = new ArrayList<String>();
        List<String> Blank = new ArrayList<String>();

        if(A ==true){
            if(N==true){
                for(int i=0; i<Data.size(); i++){
                    try {
                        if (Data.get(i).equals(null)) {
                            Blank.add(null);
                            continue;
                        }
                    } catch (NullPointerException e){
                        Blank.add(null);
                        continue;
                    }
                    List.add(Data.get(i));
                }

                Collections.sort(List);

                for(int i=0; i<List.size(); i++){
                    Blank.add(List.get(i));
                }
                this.Data =Blank;
            }
            else{
                for(int i=0; i<Data.size(); i++){
                    try {
                        if(!Data.get(i).equals(null)) {
                            List.add(Data.get(i));
                        }
                    } catch (NullPointerException e){}
                }

                Collections.sort(List);

                for(int i=0; i<Data.size(); i++){
                    try {
                        if (Data.get(i).equals(null)) {
                            Blank.add(null);
                        }
                    } catch (NullPointerException e){
                        Blank.add(null);
                    }

                }

                for(int i=0; i<Blank.size(); i++){
                    List.add(Blank.get(i));
                }
                this.Data = List;
            }
        }
        else{
            if(N==true){
                for(int i=0; i<Data.size(); i++){
                    try {
                        if (Data.get(i).equals(null)) {
                            Blank.add(null);
                            continue;
                        }
                    }
                    catch (NullPointerException e){
                        Blank.add(null);
                        continue;
                    }
                    List.add(Data.get(i));
                }

                Collections.sort(List, Collections.reverseOrder());

                for(int i=0; i<List.size(); i++){
                    Blank.add(List.get(i));
                }
                this.Data = Blank;
            }
            else{

                for(int i=0; i<Data.size(); i++){
                    try {
                        if (!Data.get(i).equals(null)) {
                            List.add(Data.get(i));
                        }
                    } catch (NullPointerException e){

                    }
                }

                Collections.sort(List, Collections.reverseOrder());


                for(int i=0; i<Data.size(); i++){
                    try {
                        if (Data.get(i).equals(null)) {
                            Blank.add(null);
                        }
                    } catch (NullPointerException e){
                        Blank.add(null);
                    }

                }

                for(int i=0; i<Blank.size(); i++){
                    List.add(Blank.get(i));
                }
                this.Data =List;
            }
        }

    }

    @Override
    public String getHeader() {
        return this.Header;
    }

    @Override
    public String getValue(int index) {
        return this.Data.get(index);
    }

    @Override
    public <T extends Number> T getValue(int index, Class<T> t) {
        return null;
    }

    @Override
    public void setValue(int index, String value) {
        this.Data.set(index, value);
    }

    @Override
    public <T extends Number> void setValue(int index, T value) {

    }

    @Override
    public int count() {
        return this.Data.size();
    }

    void print_Head(int t){
        int cnt= getHeader().length();
        for(int i=0; i<count(); i++){
            try{
                if(cnt < getValue(i).length()){
                    cnt = getValue(i).length();
                }
            }
            catch (NullPointerException e){
                cnt =cnt;
            }
        }

        try {
            cnt = cnt - getHeader().length();
        } catch (NullPointerException e){
            cnt = cnt -4;
        }

        String blank ="";

        for(int i=0; i<cnt; i++){
            blank +=" ";
        }
        System.out.printf("%s%s |", blank,getHeader());
    }
    void print(int t){
        int cnt= getHeader().length();
        for(int i=0; i<count(); i++){
            try {
                if (cnt < getValue(i).length()) {
                    cnt = getValue(i).length();
                }
            } catch (NullPointerException e){
                cnt = cnt;
            }
        }

        try {
            cnt = cnt - getValue(t).length();
        } catch(NullPointerException e){
            cnt = cnt -4;
        }


        String blank ="";

        for(int i=0; i<cnt; i++){
            blank +=" ";
        }

        System.out.printf("%s%s |", blank,getValue(t));
    }
    @Override
    public void print() {
    }

    @Override
    public boolean isNumericColumn() {
        return false;
    }

    @Override
    public long getNullCount() {
        long null_cnt =0;
        for(int i=0; i<Data.size(); i++){
            try {
                if (Data.get(i).equals(null)) {
                    null_cnt++;
                }
            } catch (NullPointerException e){
                null_cnt++;
            }
        }
        return null_cnt;
    }

    @Override
    public long getNumericCount() {
        return 0;
    }

    @Override
    public double getNumericMin() {
        double Min = 99999999999999.9999999999999;

        for(int i=0; i<Data.size(); i++){
            try {
                if(Min > Double.parseDouble(Data.get(i))){
                    Min = Double.parseDouble(Data.get(i));
                }
            } catch (NullPointerException e){

            }

        }

        return Min;
    }

    @Override
    public double getNumericMax() {
        double Max = 0;

        for(int i=0; i<Data.size(); i++){
            try {
                if(Max < Double.parseDouble(Data.get(i))){
                    Max = Double.parseDouble(Data.get(i));
                }
            } catch (NullPointerException e){

            }

        }

        return Max;
    }

    @Override
    public double getMean() {
        double Mean = 0;
        double cnt =0;

        for(int i=0; i<Data.size(); i++){
            try{
                if(!Data.get(i).equals(null))
                    cnt++;
            } catch (NullPointerException e){ }
        }

        for(int i=0; i<Data.size(); i++) {
            try {
                Mean += Double.parseDouble(Data.get(i));
            } catch (NullPointerException e){

            }
        }

        Mean = Mean/cnt;

        return Mean;
    }

    @Override
    public double getStd() {
        double Mean = getMean();
        double ret = 0;

        for(int i=0; i<Data.size(); i++){
            try {
                Double num = Double.parseDouble(Data.get(i)) - Mean;
                ret += num * num;
            } catch (NullPointerException e){

            }
        }

        ret = ret/Double.parseDouble(String.valueOf(Data.size()));

        ret = Math.sqrt(ret);

        return ret;
    }

    @Override
    public double getQ1() {
        return 0;
    }

    @Override
    public double getMedian() {
        return 0;
    }

    @Override
    public double getQ3() {
        return 0;
    }

    @Override
    public boolean fillNullWithMean() {
        String Dtype = checkDtype();

        if(!Dtype.equals("String")){
            double Mean = getMean();

            for(int i=0; i<Data.size(); i++){
                try {
                    if (Data.get(i).equals(null)) {
                        Data.set(i, Double.toString(Mean));
                    }
                } catch (NullPointerException e){
                    Data.set(i, Double.toString(Mean));
                }
            }

            return true;
        }



        return false;
    }

    @Override
    public boolean fillNullWithZero() {
        String Dtype = checkDtype();

        if (!Dtype.equals("String")) {
            for (int i = 0; i < Data.size(); i++) {
                try {
                    if (Data.get(i).equals(null)) {
                        Data.set(i, "0");
                    }
                } catch (NullPointerException e) {
                    Data.set(i, "0");
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean standardize() {
        String Dtype = checkDtype();

        if(!Dtype.equals("String")){
            double mean = getMean();
            double std = getStd();

            for(int i=0; i<Data.size(); i++){
                try {
                    double number = Double.parseDouble(Data.get(i));
                    number = (number - mean)/std;

                    Data.set(i, Double.toString(number));
                } catch (NullPointerException e){

                }
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean normalize() {
        String Dtype = checkDtype();

        if(!Dtype.equals("String")){
            double Max = getNumericMax();
            double Min = getNumericMin();

            for(int i=0; i<Data.size(); i++){
                try {
                    double number = Double.parseDouble(Data.get(i));
                    number = (number - Min) / (Max - Min);
                    Data.set(i, Double.toString(number));
                } catch (NullPointerException e){

                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean factorize() {
        List<String> list = new ArrayList<String>();


        for(int i=0; i<Data.size(); i++){
            boolean check = true;
            for(int j=0; j<list.size(); j++){
                try {
                    if (list.get(j).equals(Data.get(i))) {
                        check = false;
                        break;
                    }
                } catch (NullPointerException e){
                    return false;
                }
           }
            if(check == true){
                list.add(Data.get(i));
            }
        }

        int size = list.size();
        if(size ==2){
            for(int i=0; i<Data.size(); i++){
                if(Data.get(i).equals(list.get(0))){
                    Data.set(i, "0");
                }
                else
                    Data.set(i, "1");
                }
                return true;
            }

            return false;
        }

   }


