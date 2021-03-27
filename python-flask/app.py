import numpy as np
from flask import Flask,request,jsonify
import pickle
import requests,ssl
from flask_cors import CORS
app=Flask(__name__)
model=pickle.load(open('model.pkl','rb'))
CORS(app)

@app.route('/predict',methods=['POST'])
def predict():
    int_features=[]
    print(request)
    b_p=request.json['battery_power']
    int_features.append(int(b_p))
    b_l=request.json['blue']
    int_features.append(int(b_l))
    c_s=request.json['clock_speed']
    int_features.append(float(c_s))
    d_s=request.json['dual_sim']
    int_features.append(int(d_s))
    f_c=request.json['fc']
    int_features.append(int(f_c))
    f_g=request.json['four_g']
    int_features.append(int(f_g))
    i_m=request.json['int_memory']
    int_features.append(int(i_m))
    m_d=request.json['m_dep']
    int_features.append(float(m_d))
    m_w=request.json['mobile_wt']
    int_features.append(int(m_w))
    n_c=request.json['n_cores']
    int_features.append(int(n_c))
    p_c=request.json['pc']
    int_features.append(int(p_c))
    p_h=request.json['px_height']
    int_features.append(int(p_h))
    p_w=request.json['px_width']
    int_features.append(int(p_w))
    r_m=request.json['ram']
    int_features.append(int(r_m))
    s_h=request.json['sc_h']
    int_features.append(int(s_h))
    s_w=request.json['sc_w']
    int_features.append(int(s_w))
    t_t=request.json['talk_time']
    int_features.append(int(t_t))
    t_g=request.json['three_g']
    int_features.append(int(t_g))
    t_s=request.json['touch_screen']
    int_features.append(int(t_s))
    w_f=request.json['wifi']
    int_features.append(int(w_f))

    final_features=[np.array(int_features)]
    prediction=model.predict(final_features)
    output=int(prediction)
    if output==0:
        return {'message':'Mobile price range is 0 i.e very low'}
    elif output==1:
        return  {'message':'Mobile price range is 1 i.e low'}
    elif output==2:
        return  {'message':'Mobile price range is 2 i.e medium'}
    elif output==3:
        return  {'message':'Mobile price range is 3 i.e very high'}

if __name__=="__main__":
    app.run(debug=True)
    
    
