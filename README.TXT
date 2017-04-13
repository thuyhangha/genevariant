I> What you’ll need
	JDK 1.8 or later
	Maven 3.0+
	You can also import the code straight into your IDE:
		Spring Tool Suite (STS)
	Database MySQL
	
II>	Feature Complete
1.	Must fetch data from http://oncokb.org/api/v1/genes/673/variants and use that data to populate the various tables (likely to be 2 tables) in your local database.
2.	Filtering: We only want genes that are listed as an “OncoGene”
3.	QC: Gene results that are missing an entrezGeneId should be flagged as erroneous
4.	Data should be deposited into DB format prior to loading in to database
5.	Webservice should have restful endpoint(s) that follow REST best practices
6.	The end points of the webservice should return data in JSON format.
	a.	The data should also be paginated with full HATEOAS support.
	b.	The API should support GET requests only.

	TECHNOLOGY: Spring Boot, MVC Webservices, JPA, HATEOAS
	
III> Setup
1. Import project

2. Go to genevariant\src\main\resources\application.properties to change user name and password to connect database

3. Create MySQL schema name: variants
	
III> URL Reference

1. Get data from http://oncokb.org/api/v1/genes/673/variants and import to database mySQL
http://localhost:8009/api/data-init

2. Get all genes by page number and size (number of elements which we want to load)
 http://localhost:8009/api/genes?page=1&size=10

3. Get Gene by id: http://localhost:8009/api/genes/673

4. Get variants by gene id, page and size
http://localhost:8009/api/genes/673/variants?page=1&size=10

5. Get all variants by page and size
http://localhost:8009/api/variants?page=1&size=10

6. Get variant by id
http://localhost:8009/api/variants/1


