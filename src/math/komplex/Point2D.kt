package math.komplex
import kotlin.math.*
val Complex.X
    get() = this.real
val Complex.Y
    get() = this.img
fun Complex.angle()=this.phase()
fun vec(A:Complex,B:Complex)=B-A
fun dotProduct(A:Complex,B:Complex)=(A.conjugate()*B).real
fun crossProduct(A:Complex,B:Complex)=(A.conjugate()*B).img
fun Complex.length()=this.abs()
fun Complex.normalize()=this/this.abs()
fun rotateAroundO(p:Complex,ang:Double)=p* exp(ang*img)
fun rotateAroundA(p:Complex,ang:Double,about:Complex)=rotateAroundO(vec(about,p),ang)+about
fun reflectO(v:Complex,m:Complex)=(((v)/(m)).conjugate()*(m))
fun reflect(p:Complex, p0:Complex, p1:Complex):Complex {
    val z = p-p0
    val w = p1-p0
    return (z/w).conjugate()*w + p0 // Refelect point p1 around p0p1
}

fun fixAngle(A:Double): Double =if(A > 1) 1.0 else if (A < -1) -1.0 else A

// return min angle: aOb / bOa
// dp(v1, v2) = |v1|*|v2|*cos(theta)
fun angleO( a:Complex, O:Complex, b:Complex):Complex {
    val v1=(a - O)
    val v2=(b - O)

    return Complex.fromPolar(1.0, acos(fixAngle ( dotProduct(v1, v2) / v1.length() / v2.length() )) )
}

fun getAng(a:Complex, b:Complex, c:Complex):Double {
    var ang =  vec(b, c).angle() -  vec(b, a).angle()
    if(ang< 0)
        ang+=2*PI
    return ang
}
    /*
    complex<double> num1(2, 3);	// 2 + 3i
    std::cout << num1.real() << "+" << num1.imag() << "i\n";	// 2 + 3i
    complex<double> num2(1, 1);
    cout << "Modulus = " << abs(num2) << "\n";			// r = 1.41421
    cout << "Argument = " << arg(num2) << "\n";			// theta radian = 0.785398
    cout << "Angle = " << arg(num2) * 180 / PI << "\n";	// theta degree = 45
    cout << "Norm = " << norm(num2) << "\n";			// 2 (1*1 + 1*1)
    complex<double> num3 = std::polar(1.41421, 0.785398);
    cout << "(x+iy) from polar are: " << num3 << "\n";	// (0.999998,0.999997)
    complex<double> zero;
    complex<double> x_part = 15;
    cout << x_part << "\n";				// (15,0)
    complex<double> a(1, 2);
    complex<double> b(3, 4);
    cout<<a+b<<"\n";	// (4,6)
    cout<<a-b<<"\n";	// (-2,-2)
    cout<<a*b<<"\n";	// (-5,10)
    cout<<b*2.0<<"\n";	// (6,8)
    cout<<b/2.0<<"\n";	// (1.5,2)
    cout << fixed << std::setprecision(1);
    complex<double> i = -1;
    cout<<sqrt(i)<<"\n";		// (0,1)
    complex<double> c(2, 3);
    cout<<conj(c)<<"\n";		// (2,-3)
    cout<<pow(c, 2)<<"\n";		// (-5,12)
    complex<double> i1 (0, -1);
    cout<<exp(i1 * PI)<<"\n";	// (-1, 0)
     std::cout << std::fixed << std::setprecision(1);
     std::complex<double> z1 = 1i * 1i;     // imaginary unit squared
     std::cout << "i * i = " << z1 << '\n';
     std::complex<double> z2 = std::pow(1i, 2); // imaginary unit squared
     std::cout << "pow(i, 2) = " << z2 << '\n';
     double PI = std::acos(-1);
     std::complex<double> z3 = std::exp(1i * PI); // Euler's formula
     std::cout << "exp(i * pi) = " << z3 << '\n';
     std::complex<double> z4 = 1. + 2i, z5 = 1. - 2i; // conjugates
     std::cout << "(1+2i)*(1-2i) = " << z4*z5 << '\n';
     */

