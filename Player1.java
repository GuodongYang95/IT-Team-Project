{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf600
{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red204\green108\blue29;\red217\green232\blue247;\red230\green230\blue250;
\red18\green144\blue195;\red249\green250\blue244;\red30\green181\blue64;\red121\green171\blue255;\red128\green128\blue128;
\red242\green242\blue0;\red128\green242\blue246;\red177\green102\blue218;\red167\green236\blue33;\red102\green225\blue248;
\red243\green236\blue121;}
{\*\expandedcolortbl;;\csgenericrgb\c80000\c42353\c11373;\csgenericrgb\c85098\c90980\c96863;\csgenericrgb\c90196\c90196\c98039;
\csgenericrgb\c7059\c56471\c76471;\csgenericrgb\c97647\c98039\c95686;\csgenericrgb\c11765\c70980\c25098;\csgenericrgb\c47451\c67059\c100000;\csgenericrgb\c50196\c50196\c50196;
\csgenericrgb\c94902\c94902\c0;\csgenericrgb\c50196\c94902\c96471;\csgenericrgb\c69412\c40000\c85490;\csgenericrgb\c65490\c92549\c12941;\csgenericrgb\c40000\c88235\c97255;
\csgenericrgb\c95294\c92549\c47451;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs24 \cf2 package\cf3  commandline\cf4 ;\cf0 \
\cf2 import\cf3  java\cf4 .\cf3 util\cf4 .\cf3 ArrayList\cf4 ;\cf0 \
\cf2 import\cf3  java\cf4 .\cf3 util\cf4 .\cf3 List\cf4 ;\cf0 \
\cf2 public\cf3  \cf2 class\cf3  \cf5 cardHold\cf3  \cf6 \{\cf0 \
\
\pard\pardeftab720\partightenfactor0
\cf3 	\cf2 public\cf3  \cf2 static\cf3  \cf2 void\cf3  \cf7 main\cf6 (\cf5 String\cf6 []\cf3  \cf8 args\cf6 )\cf3  \cf6 \{\cf0 \
\cf3 			\cf9 //  Player ID\cf0 \
\cf3 			\cf2 private\cf3  \cf5 Integer\cf3  \cf10 \ul \ulc10 ID\cf4 \ulnone ;\cf0 \
\cf3 			\cf9 //  Player Name\cf0 \
\cf3 			\cf2 private\cf3  \cf5 String\cf3  \cf10 \ul \ulc10 name\cf4 \ulnone ;\cf0 \
\cf3 			\cf9 //  Player Card\cf0 \
\cf3 			\cf11 List\cf4 <\cf12 \ul \ulc12 Card\cf4 \ulnone >\cf3  \cf10 cardList\cf4 ;\cf0 \
\cf3 			\cf0 \
\cf3 			\cf2 \ul \ulc2 public\cf3 \ulnone  \cf13 cardHold\cf6 ()\{\cf0 \
\cf3 			\cf6 \ul \ulc6 \}\cf0 \ulnone \
\cf3 			\cf0 \
\cf3 			\cf2 public\cf3  \cf7 \ul \ulc7 Player\cf6 \ulc6 (\cf5 \ulc5 Integer\cf3 \ulc3  \cf8 \ulc8 ID\cf4 \ulc4 ,\cf5 \ulc5 String\cf3 \ulc3  \cf8 \ulc8 name\cf6 \ulc6 )\ulnone \{\cf0 \
\cf3 				\cf2 this\cf4 .\cf14 \ul \ulc14 ID\cf3 \ulnone  \cf4 =\cf3  \cf8 ID\cf4 ;\cf0 \
\cf3 				\cf2 this\cf4 .\cf14 \ul \ulc14 name\cf3 \ulnone  \cf4 =\cf3  \cf8 name\cf4 ;\cf0 \
\cf3 				\cf2 this\cf4 .\cf14 \ul \ulc14 cardList\cf3 \ulnone  \cf4 =\cf3  \cf2 new\cf3  \cf13 ArrayList\cf4 <\cf12 \ul \ulc12 Card\cf4 \ulnone >\cf6 ()\cf4 ;\cf0 \
\cf3 			\cf6 \}\cf0 \
\cf3 		 \cf0 \
\cf3 			\cf2 public\cf3  \cf5 Integer\cf3  \cf7 getID\cf6 ()\cf3  \cf6 \{\cf0 \
\cf3 				\cf2 return\cf3  \cf15 ID\cf4 ;\cf0 \
\cf3 			\cf6 \}\cf0 \
\cf3 		 \cf0 \
\cf3 			\cf2 public\cf3  \cf2 void\cf3  \cf7 setID\cf6 (\cf5 Integer\cf3  \cf8 iD\cf6 )\cf3  \cf6 \{\cf0 \
\cf3 				\cf15 ID\cf3  \cf4 =\cf3  \cf8 iD\cf4 ;\cf0 \
\cf3 			\cf6 \}\cf0 \
\cf3 		 \cf0 \
\cf3 			\cf2 public\cf3  \cf5 String\cf3  \cf7 getName\cf6 ()\cf3  \cf6 \{\cf0 \
\cf3 				\cf2 return\cf3  \cf15 name\cf4 ;\cf0 \
\cf3 			\cf6 \}\cf0 \
\cf3 		 \cf0 \
\cf3 			\cf2 public\cf3  \cf2 void\cf3  \cf7 setName\cf6 (\cf5 String\cf3  \cf8 name\cf6 )\cf3  \cf6 \{\cf0 \
\cf3 				\cf2 this\cf4 .\cf14 \ul \ulc14 name\cf3 \ulnone  \cf4 =\cf3  \cf8 name\cf4 ;\cf0 \
\cf3 			\cf6 \ul \ulc6 \}\cf0 \ulnone \
\cf3 			\cf0 \
\cf3 		\cf6 \}\cf0 \
\
\pard\pardeftab720\partightenfactor0
\cf6 \}\cf0 \
}