package model;

public class BookModel {
    private String bookname;
    private String bookauthor;
    private int bookyear;
    private int bookid;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "bookname='" + bookname + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", bookyear=" + bookyear +
                ", bookid=" + bookid +
                '}';
    }

    public BookModel(int bookid, String bookname, String bookauthor, int bookyear) {
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookyear = bookyear;
        this.bookid = bookid;
    }

    public int getBookid() {

        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getBookyear() {
        return bookyear;
    }

    public void setBookyear(int bookyear) {
        this.bookyear = bookyear;
    }

    public BookModel() { }
}
