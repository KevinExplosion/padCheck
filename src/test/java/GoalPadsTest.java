import org.junit.*;
import static org.junit.Assert.*;

public class GoalPadsTest {

  @Test
  public void newGoalPads_instantiatesCorrectly() {
    GoalPads testGoalPads = new GoalPads(11, 38);
    assertEquals(true, testGoalPads instanceof GoalPads);
  }

  @Test
  public void areRegulation_isFalseWhenNotRegulationSize() {
    GoalPads testGoalPads = new GoalPads(12, 40);
    assertEquals(false, testGoalPads.isRegulation());
  }

  @Test
  public void areRegulation_isFalseWhenTooWide() {
    GoalPads testGoalPads = new GoalPads(12, 30);
    assertEquals(false, testGoalPads.isRegulation());
  }

  @Test
  public void areRegulation_isFalseWhenTooLong() {
    GoalPads testGoalPads = new GoalPads(10, 40);
    assertEquals(false, testGoalPads.isRegulation());
  }

  @Test
  public void areRegulation_isTrueWhenRegulationSize() {
    GoalPads testGoalPads = new GoalPads(10, 34);
    assertEquals(true, testGoalPads.isRegulation());
  }
}
