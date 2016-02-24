public class GoalPads{
  private int mWidth;
  private int mLength;

  public GoalPads(int width, int length) {
    mWidth = width;
    mLength = length;
  }

  public int getWidth() {
    return mWidth;
  }

  public int getLength() {
    return mLength;
  }

  public boolean isRegulation() {
    return mWidth <= 11 && mLength <= 38;
  }
}
