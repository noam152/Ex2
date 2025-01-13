import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class myCellTest {

    @Test
    void isNumber() {
        String[] validNumber = {"70", "-35", "4.17", "0"};
        for (int i = 0; i < validNumber.length; i = i + 1) {
            boolean ok = myCell.isNumber(validNumber[i]);
            assertTrue(ok);
        }
        String[] invalidNumber = {"-a", "@#$", "bsf"};
        for (int i = 0; i < invalidNumber.length; i = i + 1) {
            boolean not_ok = myCell.isNumber(invalidNumber[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void isText() {
        String[] validText = {"mvsmg","42gdg","!3gx&","hello world"};
        for (int i = 0; i < validText.length; i = i + 1) {
            boolean ok = myCell.isText(validText[i]);
            assertTrue(ok);
        }
        String[] invalidText = {"43","=4+6"};
        for (int i = 0; i < invalidText.length; i = i + 1) {
            boolean not_ok = myCell.isText(invalidText[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void isForm() {
        String[] validForm = {"=3+4","=4","=(9*7)","=(1+2)*(3+4)","=((1+2)*(3+4))"};
        for (int i = 0; i < validForm.length; i = i + 1) {
            boolean ok = myCell.isForm(validForm[i]);
            assertTrue(ok);
        }
        String[] invalidForm = {"3+4","=6e","=jojo",")()"};
        for (int i = 0; i < invalidForm.length; i = i + 1) {
            boolean not_ok = myCell.isForm(invalidForm[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void isCell() {
        String[] validCell = {"a32", "c5", "w87"};
        for (int i = 0; i < validCell.length; i = i + 1) {
            boolean ok = myCell.isCell(validCell[i]);
            assertTrue(ok);
        }
        String[] invalidCell = {"a324", "c", "w8798","43v"};
        for (int i = 0; i < invalidCell.length; i = i + 1) {
            boolean not_ok = myCell.isCell(invalidCell[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void isVaildForm() {
        String[] validForm = {"=3+a56","=6*v45","=(9*7)/R98"};
        for (int i = 0; i < validForm.length; i = i + 1) {
            boolean ok = myCell.isForm(validForm[i]);
            assertTrue(ok);
        }
        String[] invalidForm = {"3+a43","=AA","=7A","(","=a102"};
        for (int i = 0; i < invalidForm.length; i = i + 1) {
            boolean not_ok = myCell.isForm(invalidForm[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void parentheses() {
        String[] checks = {"(a + (b * c) + d)", "(a + d)", "(a)", "()"};
        int[] compare = {15,8,3,2};
        for (int i = 0; i < checks.length; i = i + 1) {
            compare[i] = myCell.parentheses(checks[i]);
            assertEquals(compare[i], compare[i]);
        }
    }
    @Test
    void lastOperator() {
        assertEquals(1, myCell.lastOp("1+2"));
        assertEquals(1, myCell.lastOp("3-4"));
        assertEquals(1, myCell.lastOp("5*6"));
        assertEquals(1, myCell.lastOp("7/8"));
        assertEquals(5, myCell.lastOp("1+2*3-4")); // '-' הוא האופרטור הראשי האחרון
        assertEquals(7, myCell.lastOp("(1+2)*3-4")); // '-' הוא האופרטור הראשי האחרון
        assertEquals(5, myCell.lastOp("(1+2)*(3+4)"));
    }
    @Test
    void xCell(){
        assertEquals(Spreadsheet.xCell("Z13"),25);
        assertEquals(Spreadsheet.xCell("c13"),2);
        assertEquals(Spreadsheet.xCell("AA13"),-1);
        assertEquals(Spreadsheet.xCell("er13"),-1);
    }
    @Test
    void yCell(){
        assertEquals(Spreadsheet.yCell("x99"),99);
        assertEquals(Spreadsheet.yCell("v34"),34);
        assertEquals(Spreadsheet.yCell("r100"),-1);
        assertEquals(Spreadsheet.yCell("n5"),5);
    }
}