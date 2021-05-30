package csv;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class TableImpl implements Table {

    List<ColumnImpl> col_zip = new ArrayList<ColumnImpl>();

    List<List<String>> values = new ArrayList<List<String>>(); // 값을 넣어줄 리스트
    List<List<String>> temp_data = new ArrayList<List<String>>(); //print를 사용하기 위한 임시 공간.

    ColumnImpl Head = new ColumnImpl();//헤드 넣어줄 col

    boolean isheader_on = true;
    int indexCount = 0;
    int columnsCount = 0;
    int countDouble, countInt, countString = 0;
    int null_Count = 0;






    @Override
    public String toString(){
        System.out.println("<csv.Table" + "@" + Integer.toHexString(hashCode())+">");
        if(this.isheader_on == true){
            System.out.println("RangeIndex: "+(this.temp_data.size()-1) + " entries, 0 to "+ (this.temp_data.size()-2));
        }
        else{
            System.out.println("RangeIndex: "+(this.temp_data.size()-0) + " entries, 0 to "+ (this.temp_data.size()-1));
        }
        System.out.println("Data columns (total "+ this.col_zip.size() + " columns):");

        System.out.printf("%4s |%20s | %20s | %8s\n","#","Column", "Non_Null Count", "Dtype");

        int cnt_d = 0, cnt_s =0, cnt_i =0;
        for(int i=0; i<col_zip.size(); i++){
            String temp = Integer.toString(col_zip.get(i).Non_Null_cnt) + " non_null";
            if(isheader_on == true) {

                System.out.printf("%4s |%20s | %20s | %8s\n", i, this.Head.header.get(i), temp, col_zip.get(i).Data_Type);
            }
            else{
                System.out.printf("%4s |%20s | %20s | %8s\n", i, col_zip.get(i).datas.get(0), temp, col_zip.get(i).Data_Type);
            }
            if(this.col_zip.get(i).Data_Type.equals("String")){
                cnt_s++;
            }
            else if(this.col_zip.get(i).Data_Type.equals("double")){
                cnt_d++;
            }
            else if(this.col_zip.get(i).Data_Type.equals("int")){
                cnt_i++;
            }
        };
        System.out.printf("dtypes: double(%d), int(%d), String(%d)\n", cnt_d, cnt_i, cnt_s);
        return "";
    }

    @Override
    public void print() {

        for (int i = 0; i < this.temp_data.size(); i++) {
            System.out.println(this.temp_data.get(i));
        }

        temp_data = values;// 임시 값들을 출력해주고, 다시 원본을 넣어줌.

    }

    @Override
    public Table getStats() {
        return null;
    }

    @Override
    public Table head() {
        return null;
    }

    @Override
    public Table head(int lineCount) {
        return null;
    }

    @Override
    public Table tail() {
        return null;
    }

    @Override
    public Table tail(int lineCount) {
        return null;
    }

    @Override
    public Table selectRows(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public Table selectRowsAt(int... indices) {
        return null;
    }

    @Override
    public Table selectColumns(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public Table selectColumnsAt(int... indices) {
        return null;
    }

    @Override
    public <T> Table selectRowsBy(String columnName, Predicate<T> predicate) {
        return null;
    }

    @Override
    public Table sort(int byIndexOfColumn, boolean isAscending, boolean isNullFirst) {
        return null;
    }

    @Override
    public Table shuffle() {
        return null;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Column getColumn(int index) {
        return null;
    }

    @Override
    public Column getColumn(String name) {
        return null;
    }

    @Override
    public boolean fillNullWithMean() {
        return false;
    }

    @Override
    public boolean fillNullWithZero() {
        return false;
    }

    @Override
    public boolean standardize() {
        return false;
    }

    @Override
    public boolean normalize() {
        return false;
    }

    @Override
    public boolean factorize() {
        return false;
    }
}
