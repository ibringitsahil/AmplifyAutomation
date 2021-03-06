package com.amplify.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amplify.test.baseTest.Functions;

public class ViewLoanPopup extends Functions {
	WebDriver driver;
	List<WebElement> rowsInTaskTable;
	List<WebElement> columnsInTaskTable;
	
	/*@FindBy(xpath="//*[contains(@class,'mx-name-tabPage6')]")*/
	@FindBy(xpath="//*[contains(@class,'mx-name-tabControl1')]/ul/li[4]/a")
	WebElement tasksTabinViewLoanPopup;
	
	@FindBy(xpath="//div[text()='Task Name']")
	WebElement taskNameColumn;
	
	@FindBy(xpath="//div[@class='mx-grid mx-datagrid mx-name-grid1']/div[3]/div/table[2]/tbody/tr/td[1]")
	WebElement firstRowTaskName;
	
	@FindBy(xpath="//div[@class='mx-grid mx-datagrid mx-name-grid1']/div[3]/div/table[2]/tbody/tr/td[2]/div")
	WebElement firstRowStatusName;
	
	@FindBy(xpath="//div[contains(@class,'mx-dataview mx-name-dataView1')]/div[2]/button")
	WebElement closeViewLoanPopup;
	
	public  ViewLoanPopup(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void getData(){
	rowsInTaskTable =driver.findElements(By.xpath("//*[@id='mxui_widget_DataGrid_4']/div[3]/div/table[2]/tbody/tr"));
	for(int i=0;i<=rowsInTaskTable.size();i++){
		columnsInTaskTable.addAll(driver.findElements(By.xpath("//*[@id='mxui_widget_DataGrid_4']/div[3]/div/table[2]/tbody/tr["+i+"]/td[1]")));
	}
	int i=0;
	String[] s=new String[columnsInTaskTable.size()];
	for(WebElement a:columnsInTaskTable){
		s[i]=a.getText();
		i++;
	}
	}
	public void clockTasksTabinViewLoanPopup(){
		waitForElement(driver, 12, tasksTabinViewLoanPopup);	
		driver.findElement(By.xpath("//*[contains(@class,'mx-table mx-name-table1')]/tbody/tr[2]/td/div/ul/li[4]/a")).click();		
	}
	public void clickTaskNameColumn(){
		waitForElement(driver, 12, taskNameColumn);
		taskNameColumn.click();
	}
	public String getTaskNameinFirstRow(){
		String firstRowTaskName1= firstRowTaskName.getText();
		return firstRowTaskName1;
	}
	public String getStatusNameinFirstRow(){
		String firstRowStatusName1= firstRowStatusName.getText();
		return firstRowStatusName1;
	}
	public void closeViewLoanPopup(){
		closeViewLoanPopup.click();
	}
	
}
