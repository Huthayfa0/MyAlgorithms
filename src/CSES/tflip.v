module tflip( clk,
              resetn,
              t,
              q,
              nq
               );

  input        clk;
  input        resetn;
  input        t;
  output logic q;
  output logic nq;
  

  always @(posedge clk) begin
    if(resetn==0) begin
      q<=0;
      nq<=1;
    end else if(t==1) begin
      q<=nq;
      nq<=q;
    end
  end
endmodule