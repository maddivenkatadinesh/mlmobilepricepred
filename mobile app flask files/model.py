import pandas as pd
import pickle
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split, GridSearchCV, cross_val_score
from sklearn.metrics import classification_report, confusion_matrix

location="./data.csv"
data=pd.read_csv(location)

y=data['price_range']
x=data.drop('price_range',axis=1)

x_train , x_valid, y_train, y_valid = train_test_split(x,y,test_size=0.2,random_state=101,stratify=y)

model_knn= KNeighborsClassifier(n_neighbors=3)
model_knn.fit(x_train,y_train)

#y_pred_knn = model_knn.predict(x_valid)

pickle.dump(model_knn, open('model.pkl','wb'))

