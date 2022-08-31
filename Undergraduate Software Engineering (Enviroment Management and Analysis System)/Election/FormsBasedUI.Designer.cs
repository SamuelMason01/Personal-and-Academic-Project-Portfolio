namespace Election
{
    partial class FormsBasedUI
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.configBtn = new System.Windows.Forms.Button();
            this.RunProducerConsumerBtn = new System.Windows.Forms.Button();
            this.progressLbl = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.LocationListbox = new System.Windows.Forms.ListBox();
            this.label2 = new System.Windows.Forms.Label();
            this.reportLbl = new System.Windows.Forms.Label();
            this.DataListbox = new System.Windows.Forms.ListBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lstFunctionality = new System.Windows.Forms.ListBox();
            this.btnclose = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // configBtn
            // 
            this.configBtn.Location = new System.Drawing.Point(26, 11);
            this.configBtn.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.configBtn.Name = "configBtn";
            this.configBtn.Size = new System.Drawing.Size(255, 32);
            this.configBtn.TabIndex = 0;
            this.configBtn.Text = "Create Config Data";
            this.configBtn.UseVisualStyleBackColor = true;
            this.configBtn.Click += new System.EventHandler(this.configBtn_Click);
            // 
            // RunProducerConsumerBtn
            // 
            this.RunProducerConsumerBtn.Enabled = false;
            this.RunProducerConsumerBtn.Location = new System.Drawing.Point(26, 47);
            this.RunProducerConsumerBtn.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.RunProducerConsumerBtn.Name = "RunProducerConsumerBtn";
            this.RunProducerConsumerBtn.Size = new System.Drawing.Size(255, 30);
            this.RunProducerConsumerBtn.TabIndex = 1;
            this.RunProducerConsumerBtn.Text = "Load Config Data";
            this.RunProducerConsumerBtn.UseVisualStyleBackColor = true;
            this.RunProducerConsumerBtn.Click += new System.EventHandler(this.RunProducerConsumerBtn_Click);
            // 
            // progressLbl
            // 
            this.progressLbl.AutoSize = true;
            this.progressLbl.Location = new System.Drawing.Point(371, 19);
            this.progressLbl.Name = "progressLbl";
            this.progressLbl.Size = new System.Drawing.Size(94, 17);
            this.progressLbl.TabIndex = 2;
            this.progressLbl.Text = "Awaiting Data";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(300, 19);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(52, 17);
            this.label1.TabIndex = 3;
            this.label1.Text = "Status:";
            // 
            // LocationListbox
            // 
            this.LocationListbox.Font = new System.Drawing.Font("Microsoft YaHei", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LocationListbox.FormattingEnabled = true;
            this.LocationListbox.ItemHeight = 19;
            this.LocationListbox.Location = new System.Drawing.Point(431, 152);
            this.LocationListbox.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.LocationListbox.Name = "LocationListbox";
            this.LocationListbox.Size = new System.Drawing.Size(502, 289);
            this.LocationListbox.TabIndex = 4;
            this.LocationListbox.SelectedIndexChanged += new System.EventHandler(this.constituencyListbox_SelectedIndexChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(428, 126);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(73, 17);
            this.label2.TabIndex = 7;
            this.label2.Text = "Locations:";
            // 
            // reportLbl
            // 
            this.reportLbl.AutoSize = true;
            this.reportLbl.Location = new System.Drawing.Point(520, 126);
            this.reportLbl.Name = "reportLbl";
            this.reportLbl.Size = new System.Drawing.Size(0, 17);
            this.reportLbl.TabIndex = 8;
            // 
            // DataListbox
            // 
            this.DataListbox.Font = new System.Drawing.Font("Microsoft YaHei", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.DataListbox.FormattingEnabled = true;
            this.DataListbox.ItemHeight = 19;
            this.DataListbox.Location = new System.Drawing.Point(939, 152);
            this.DataListbox.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.DataListbox.Name = "DataListbox";
            this.DataListbox.Size = new System.Drawing.Size(395, 289);
            this.DataListbox.TabIndex = 9;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(936, 126);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(72, 17);
            this.label3.TabIndex = 10;
            this.label3.Text = "Readings:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(23, 126);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(91, 17);
            this.label4.TabIndex = 16;
            this.label4.Text = "Functionality:";
            // 
            // lstFunctionality
            // 
            this.lstFunctionality.Font = new System.Drawing.Font("Microsoft YaHei", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lstFunctionality.FormattingEnabled = true;
            this.lstFunctionality.ItemHeight = 19;
            this.lstFunctionality.Items.AddRange(new object[] {
            "Display all location data",
            "Display particulate total. Via Location",
            "Display particulate total. Via Date",
            "Display highest particulate total overall from all readings"});
            this.lstFunctionality.Location = new System.Drawing.Point(26, 152);
            this.lstFunctionality.Name = "lstFunctionality";
            this.lstFunctionality.Size = new System.Drawing.Size(399, 289);
            this.lstFunctionality.TabIndex = 17;
            this.lstFunctionality.SelectedIndexChanged += new System.EventHandler(this.lstFunctionality_SelectedIndexChanged);
            // 
            // btnclose
            // 
            this.btnclose.Location = new System.Drawing.Point(26, 82);
            this.btnclose.Name = "btnclose";
            this.btnclose.Size = new System.Drawing.Size(159, 32);
            this.btnclose.TabIndex = 18;
            this.btnclose.Text = "Close application";
            this.btnclose.UseVisualStyleBackColor = true;
            this.btnclose.Click += new System.EventHandler(this.btnclose_Click);
            // 
            // FormsBasedUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1346, 459);
            this.Controls.Add(this.btnclose);
            this.Controls.Add(this.lstFunctionality);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.DataListbox);
            this.Controls.Add(this.reportLbl);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.LocationListbox);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.progressLbl);
            this.Controls.Add(this.RunProducerConsumerBtn);
            this.Controls.Add(this.configBtn);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "FormsBasedUI";
            this.Text = "Election GUI";
            this.Load += new System.EventHandler(this.FormsBasedUI_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button configBtn;
        private System.Windows.Forms.Button RunProducerConsumerBtn;
        private System.Windows.Forms.Label progressLbl;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListBox LocationListbox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label reportLbl;
        private System.Windows.Forms.ListBox DataListbox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ListBox lstFunctionality;
        private System.Windows.Forms.Button btnclose;
    }
}

