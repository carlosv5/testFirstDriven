package klondike.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	SuitTest.class, 
	CardTest.class,
	WasteTest.class, 
	StockTest.class,
	PileTest.class,
	FoundationTest.class,
	GameTest.class,
})

public class AllTest {

}
