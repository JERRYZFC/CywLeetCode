#��չŷ������㷨����շת�����
#ax+by=gcb(a, b)
#���أ�x,y, gcb(a, b)
#gcb(a, b) ��Ҫ����1��Ҫ����a
def Ext_Euclid ( a , b ):
    if (b == 0):
        return 1 , 0 , a
    else:
        x , y , q=Ext_Euclid( b , a % b )
        x , y = y,( x - (a // b) * y )
        print(q)
        return x , y , q
    
a = Ext_Euclid(47,30)