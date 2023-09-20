package Pages;

import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class AddToCart extends BaseClass{
	
	public AddToCart() {
		PageFactory.initElements(driver, this);
	}

}
