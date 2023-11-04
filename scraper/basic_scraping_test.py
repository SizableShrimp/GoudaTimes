from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from bs4 import BeautifulSoup
import codecs
import re
from webdriver_manager.chrome import ChromeDriverManager

def createDriver() -> webdriver.Chrome:
	driver = webdriver.Chrome(
		service=Service(ChromeDriverManager().install())
	)
	return driver

def renderAndCreateParser(url: str) -> BeautifulSoup:
	driver = createDriver()
	wait = WebDriverWait(driver, 10)
	driver.get(url)
	get_url = driver.current_url
	wait.until(EC.url_to_be(url))
	return BeautifulSoup(driver.page_source, features="html.parser")

soup = renderAndCreateParser("https://example.com")
print(soup)
