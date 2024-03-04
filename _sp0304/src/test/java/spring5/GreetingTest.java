package spring5;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GreetingTest {

	private Greeting target = new Greeting();
	
	@Test
	public void getMessage_아침인사() {
		String msg = this.target.getMessage(5);
		assertThat(msg, is("좋은 아침입니다"));
	}
    @Test
    public void getMessage_평상시() {
        String message = this.target.getMessage(11);
        assertThat(message, is("안녕하십니까"));
    }
        
    @Test
    public void getMessage_밤인사() {
        String message = this.target.getMessage(17);
        assertThat(message, is("수고 많으십니다"));
    }
}
