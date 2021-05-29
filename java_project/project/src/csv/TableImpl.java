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
    public String toString() {


//        for(int i = 0; i<col.get(0).values_c.size();i++) {
//            System.out.println(col.get(0).values_c.get(i));
//        }
        indexCount = values.size() - 1;

        return "Table" + "@" + Integer.toHexString(hashCode()) + "\n" +

        "RangeIndex: " + indexCount +" entries, 0 to " + (indexCount-1)+ "\n" +//첫번째 줄
                "Data columns (total " + columnsCount +"): \n" +
                " # |        Column | Non-Null Count |Dtype" +"\n"+

                //중간 출력 부분


                "dtypes: double("+countDouble +"), int(" + countInt +"), String("+ countString + ")\n";
    }

    @Override
    public void print() {

//        for (int i = 0; i < this.temp_data.size(); i++) {
//            System.out.println(this.temp_data.get(i));
//        }
//
//        temp_data = values;// 임시 값들을 출력해주고, 다시 원본을 넣어줌.

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
