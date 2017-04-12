CREATE TABLE `gene1` (
  `entrezGeneId` int(11) NOT NULL,
  `hugoSymbol` varchar(45) DEFAULT NULL,
  `aliases` varchar(45) DEFAULT NULL,
  `oncogene` int(11) DEFAULT NULL,
  `tsg` int(11) DEFAULT NULL,
  PRIMARY KEY (`entrezGeneId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `variants2` (
  `alteration` int(11) NOT NULL,
  `consequence_term` varchar(45) DEFAULT NULL,
  `isGenerallyTruncating` int(11) DEFAULT NULL,
  `entrezGeneId` int(11) DEFAULT NULL,
  PRIMARY KEY (`alteration`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
