# TSM Sales Analyzer
TSM Sales Analyzer will read a *'Accounting_<realm>_sales.csv'* file, exported from the TradeSkill Master desktop app, and create a report with the most sold items from the account.

This Java program based on [wowSales2019](https://github.com/hugobrancowb/wowSales2019) project.

## How to use
1. Open the TSM Desktop App and go to the *Accounting Export* tab.

![Account Export tab](https://github.com/hugobrancowb/tsm_sales_analyzer/blob/master/readme_images_-_how_to_use/01.jpg)

1. Select your account and realm. The *Sales* box is the only box required to run our analyzer. Export to CSV to save the record file.

![Export CSV](https://github.com/hugobrancowb/tsm_sales_analyzer/blob/master/readme_images_-_how_to_use/02.jpg)

1. When you run the TSM Sales Analyzer the window below is gonna open.
  1. Select the just exported Sales CSV file. It must be a `.csv` file and have the same name as exported from the TSM Desktop App.
  1. Set the number of months you want to get from the report. It will print the report from the most recent to the older one.
  1. Set the number of items you want to get in each month's report.
  1. Click 'Get report'.

![Set the options](https://github.com/hugobrancowb/tsm_sales_analyzer/blob/master/readme_images_-_how_to_use/03.jpg)

1. If you find and errors or bugs, send an email to [hugobrancowb@gmail.com](mailto:hugobrancowb@gmail.com).