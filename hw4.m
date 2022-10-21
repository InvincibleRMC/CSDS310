values = [3 4 2 6 0.5];
operations = ["+" "x" "+" "x"];

n = length(values);

m=zeros(n);
s=zeros(n-1);
for i = 1:n
    m(i,i)=values(i);
end

for l =2:n
    for i =1:(n-l+1)
        j=i+l-1;
        m(i,j) = 0;
        for k =i:(j-1)
            q = helper(m(i,k),m(k+1,j),operations(k));
            if q > m(i,j)
                m(i,j) = q;
                s(i,j) = k;
            end
        end
    end
end
disp(m);
disp(s);
paren(values,operations,s,1,n);

function q = helper(left,right,o)
    if(strcmp(o,"+"))
        q = left+right;
    else
        q=left*right;
    end
end

function paren(values,operations,s,i,j)
    if i==length(values)
        fprintf("%d",values(i));
        return;
    end
    if i==j
        fprintf("%d %s ",values(i),operations(i));
    else
     fprintf("(");
     paren(values,operations,s,i,s(i,j))
     paren(values,operations,s,s(i,j)+1,j)
     fprintf(")");
    end
end